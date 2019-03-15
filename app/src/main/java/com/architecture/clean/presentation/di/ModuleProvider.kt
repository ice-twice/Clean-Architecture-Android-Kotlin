package com.architecture.clean.presentation.di

import com.architecture.clean.presentation.di.module.*

/**
 * This class is used to provide modules.
 */
class ModuleProvider {
    val contextModule by lazy(mode = LazyThreadSafetyMode.NONE) {
        ContextModule()
    }

    val backgroundSchedulerModule by lazy(mode = LazyThreadSafetyMode.NONE) {
        BackgroundSchedulerModule()
    }

    val postExecutionSchedulerModule by lazy(mode = LazyThreadSafetyMode.NONE) {
        PostExecutionSchedulerModule()
    }

    val navigatorModule by lazy(mode = LazyThreadSafetyMode.NONE) {
        NavigationModule()
    }

    val newsRepositoryModule by lazy(mode = LazyThreadSafetyMode.NONE) {
        NewsRepositoryModule()
    }
}