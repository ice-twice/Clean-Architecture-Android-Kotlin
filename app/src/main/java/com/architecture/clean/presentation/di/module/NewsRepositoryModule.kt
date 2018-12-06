package com.architecture.clean.presentation.di.module

import com.architecture.clean.data.NewsRepositoryImpl
import com.architecture.clean.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NewsRepositoryModule : AbstractModuleSoftReference<NewsRepository>() {

    @Provides
    @Singleton
    internal fun provideNewsRepository(): NewsRepository {
        return getInstance { NewsRepositoryImpl() }
    }
}