package com.architecture.clean.presentation.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule {
    lateinit var context: Context

    @Provides
    @Singleton
    fun provideContext(): Context = context
}