package com.architecture.clean.presentation.di.component

import com.architecture.clean.presentation.di.module.LoginModule
import com.architecture.clean.presentation.view.fragment.LoginFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [LoginModule::class])
interface LoginComponent {
    fun inject(fragment: LoginFragment)
}