package com.architecture.clean.presentation.di.component

import com.architecture.clean.presentation.di.module.*
import com.architecture.clean.presentation.fragment.LoginFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Login component.
 */
@Singleton
@Component(modules = [BackgroundSchedulerModule::class, PostExecutionSchedulerModule::class, AndroidUtilModule::class, NavigationModule::class, ContextModule::class, AuthenticationRepositoryModule::class])
interface LoginComponent {
    fun inject(fragment: LoginFragment)
}