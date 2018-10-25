package com.architecture.clean.presentation.di.module

import com.architecture.clean.presentation.navigation.Navigator
import dagger.Module
import dagger.Provides
import java.lang.ref.SoftReference
import javax.inject.Singleton

@Module
class NavigationModule : AbstractModule() {
    private var navigator: SoftReference<Navigator>? = null

    @Provides
    @Singleton
    internal fun provideNavigator(): Navigator {
        val pair = getOrCreateInstance(navigator, { Navigator() }, { instance -> SoftReference(instance) })
        navigator = pair.second
        return pair.first
    }
}