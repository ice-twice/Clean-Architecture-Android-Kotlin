package com.architecture.clean.view

import android.app.Application
import com.architecture.clean.BuildConfig
import com.squareup.leakcanary.LeakCanary

class AndroidApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // start to detect memory leaks
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this)
        }
    }
}