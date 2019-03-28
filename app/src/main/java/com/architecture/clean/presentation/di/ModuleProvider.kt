package com.architecture.clean.presentation.di

import com.architecture.clean.presentation.di.module.*

/**
 * This class is used to provide modules.
 */
class ModuleProvider {
    val contextModule by lazy(mode = LazyThreadSafetyMode.NONE) {
        ContextModule()
    }

    val backgroundSchedulerModule get() = BackgroundSchedulerModule()

    val postExecutionSchedulerModule get() = PostExecutionSchedulerModule()

    val navigatorModule get() = NavigationModule()

    val newsRepositoryModule get() = NewsRepositoryModule()
}