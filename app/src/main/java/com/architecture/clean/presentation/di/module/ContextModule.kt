package com.architecture.clean.presentation.di.module

import android.content.Context
import com.architecture.clean.presentation.di.module.base.BaseModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule : BaseModule<Context>() {

    @Provides
    @Singleton
    fun provideContext(): Context = instance!!
}