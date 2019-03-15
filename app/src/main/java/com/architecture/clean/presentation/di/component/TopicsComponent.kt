package com.architecture.clean.presentation.di.component

import com.architecture.clean.presentation.di.module.NavigationModule
import com.architecture.clean.presentation.view.topiclist.TopicListFragment
import dagger.Component
import javax.inject.Singleton

/**
 * The topics component.
 */
@Singleton
@Component(modules = [NavigationModule::class])
interface TopicsComponent {
    fun inject(fragment: TopicListFragment)
}