package com.architecture.clean.presentation.di.module

import android.content.Context
import com.architecture.clean.presentation.di.module.base.AbstractModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule : AbstractModule<Context>() {

    @Provides
    @Singleton
    fun provideContext(): Context = instance!!
}