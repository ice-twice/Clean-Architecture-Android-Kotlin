package com.architecture.clean.presentation.di.module

import com.architecture.clean.presentation.di.module.base.AbstractModuleReferenceSoft
import com.architecture.clean.presentation.navigation.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule : AbstractModuleReferenceSoft<Navigator>() {

    @Provides
    @Singleton
    internal fun provideNavigator(): Navigator {
        return getInstance { Navigator() }
    }
}