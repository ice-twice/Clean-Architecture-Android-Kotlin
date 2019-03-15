package com.architecture.clean.presentation.di.component

import com.architecture.clean.presentation.di.module.BackgroundSchedulerModule
import com.architecture.clean.presentation.di.module.NewsRepositoryModule
import com.architecture.clean.presentation.di.module.PostExecutionSchedulerModule
import com.architecture.clean.presentation.view.newslist.NewsListFragment
import dagger.Component
import javax.inject.Singleton

/**
 * The news list component.
 */
@Singleton
@Component(modules = [BackgroundSchedulerModule::class, PostExecutionSchedulerModule::class, NewsRepositoryModule::class])
interface NewsListComponent {
    fun inject(fragment: NewsListFragment)
}