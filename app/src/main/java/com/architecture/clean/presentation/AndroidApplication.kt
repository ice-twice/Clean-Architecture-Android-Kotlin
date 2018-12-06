package com.architecture.clean.presentation

import android.app.Application
import android.os.StrictMode
import com.architecture.clean.BuildConfig
import com.architecture.clean.presentation.di.ModuleProvider
import com.squareup.leakcanary.LeakCanary

class AndroidApplication : Application() {
    val moduleProvider by lazy(mode = LazyThreadSafetyMode.NONE) {
        val moduleProvider = ModuleProvider()
        moduleProvider.contextModule.instance = this
        return@lazy moduleProvider
    }

    override fun onCreate() {
        // initialize strict mode
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .penaltyFlashScreen()
                    .build())
            StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .penaltyDeath()
                    .build())
        }
        super.onCreate()
        // start to detect memory leaks
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this)
        }
    }
}