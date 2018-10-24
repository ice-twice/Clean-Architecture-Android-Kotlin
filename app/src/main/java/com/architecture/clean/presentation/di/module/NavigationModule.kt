package com.architecture.clean.presentation.di.module

import com.architecture.clean.presentation.navigation.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule {
    private val navigator by lazy(mode = LazyThreadSafetyMode.NONE) {
        Navigator()
    }

    @Provides
    @Singleton
    internal fun provideNavigator(): Navigator {
        return navigator
    }
}