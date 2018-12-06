package com.architecture.clean.presentation.di.module

import com.architecture.clean.data.NewsRepositoryImpl
import com.architecture.clean.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import java.lang.ref.SoftReference
import javax.inject.Singleton

@Module
class NewsRepositoryModule : AbstractModule() {
    private var newsRepository: SoftReference<NewsRepository>? = null

    @Provides
    @Singleton
    internal fun provideNewsRepository(): NewsRepository {
        val pair = getOrCreateInstance(newsRepository, { NewsRepositoryImpl() }, { instance -> SoftReference(instance) })
        newsRepository = pair.second
        return pair.first
    }
}