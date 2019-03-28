package com.architecture.clean.presentation.di.module

import com.architecture.clean.presentation.di.module.base.reference.BaseModuleSoftReference
import com.architecture.clean.presentation.navigation.Navigator
import dagger.Module
import dagger.Provides
import java.lang.ref.Reference
import javax.inject.Singleton

@Module
class NavigationModule : BaseModuleSoftReference<Navigator>() {
    object ReferenceInstance {
        var reference: Reference<Navigator>? = null
    }

    @Provides
    @Singleton
    fun provideNavigator(): Navigator {
        return getInstance(ReferenceInstance::reference)
        { Navigator() }
    }
}