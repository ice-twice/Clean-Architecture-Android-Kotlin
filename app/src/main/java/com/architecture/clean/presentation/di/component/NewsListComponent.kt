package com.architecture.clean.presentation.di.component

import com.architecture.clean.presentation.fragment.NewsListFragment
import dagger.Component
import javax.inject.Singleton

/**
 * The news list component.
 */
@Singleton
@Component
interface NewsListComponent {
    fun inject(fragment: NewsListFragment)
}