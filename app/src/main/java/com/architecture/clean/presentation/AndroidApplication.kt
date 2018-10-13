package com.architecture.clean.presentation

import android.app.Application
import com.architecture.clean.BuildConfig
import com.architecture.clean.presentation.di.ModuleProvider
import com.squareup.leakcanary.LeakCanary

class AndroidApplication : Application() {
    val moduleProvider by lazy(mode = LazyThreadSafetyMode.NONE) {
        ModuleProvider()
    }

    override fun onCreate() {
        super.onCreate()
        // start to detect memory leaks
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this)
        }
    }
}