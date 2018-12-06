package com.architecture.clean.presentation.di.component

import com.architecture.clean.presentation.di.module.NewsRepositoryModule
import com.architecture.clean.presentation.di.module.SchedulerModule
import com.architecture.clean.presentation.fragment.NewsListFragment
import dagger.Component
import javax.inject.Singleton

/**
 * The news list component.
 */
@Singleton
@Component(modules = [SchedulerModule::class, NewsRepositoryModule::class])
interface NewsListComponent {
    fun inject(fragment: NewsListFragment)
}