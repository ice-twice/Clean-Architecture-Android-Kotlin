package com.architecture.clean.presentation.di.module

import com.architecture.clean.data.NewsRepositoryImpl
import com.architecture.clean.domain.repository.NewsRepository
import com.architecture.clean.presentation.di.module.base.reference.BaseModuleSoftReference
import dagger.Module
import dagger.Provides
import java.lang.ref.Reference
import javax.inject.Singleton

@Module
class NewsRepositoryModule : BaseModuleSoftReference<NewsRepository>() {
    object ReferenceInstance {
        var reference: Reference<NewsRepository>? = null
    }

    @Provides
    @Singleton
    internal fun provideNewsRepository(): NewsRepository {
        return getInstance(ReferenceInstance::reference)
        { NewsRepositoryImpl() }
    }
}