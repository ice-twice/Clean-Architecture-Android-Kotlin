package com.architecture.clean.presentation.di

import com.architecture.clean.presentation.di.module.AndroidUtilModule
import com.architecture.clean.presentation.di.module.NavigationModule
import com.architecture.clean.presentation.di.module.SchedulerModule

/**
 * This class is used to provide modules.
 */
class ModuleProvider {
    val schedulerModule by lazy(mode = LazyThreadSafetyMode.NONE) {
        SchedulerModule()
    }

    val androidUtilModule by lazy(mode = LazyThreadSafetyMode.NONE) {
        AndroidUtilModule()
    }

    val navigatorModule by lazy(mode = LazyThreadSafetyMode.NONE) {
        NavigationModule()
    }
}