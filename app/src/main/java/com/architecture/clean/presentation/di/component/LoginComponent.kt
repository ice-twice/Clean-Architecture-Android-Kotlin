package com.architecture.clean.presentation.di.component

import com.architecture.clean.presentation.di.module.AndroidUtilModule
import com.architecture.clean.presentation.di.module.SchedulerModule
import com.architecture.clean.presentation.view.fragment.LoginFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Login component.
 */
@Singleton
@Component(modules = [SchedulerModule::class, AndroidUtilModule::class])
interface LoginComponent {
    fun inject(fragment: LoginFragment)
}