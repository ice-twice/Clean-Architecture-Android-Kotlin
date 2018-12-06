package com.architecture.clean.presentation.di

import com.architecture.clean.presentation.di.module.*

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

    val contextModule by lazy(mode = LazyThreadSafetyMode.NONE) {
        ContextModule()
    }

    val authenticationRepositoryModule by lazy(mode = LazyThreadSafetyMode.NONE) {
        AuthenticationRepositoryModule()
    }

    val newsRepositoryModule by lazy(mode = LazyThreadSafetyMode.NONE) {
        NewsRepositoryModule()
    }
}