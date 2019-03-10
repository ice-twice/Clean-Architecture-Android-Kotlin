package com.architecture.clean.presentation.activity

import com.architecture.clean.R
import com.architecture.clean.presentation.fragment.TopicListFragment

/**
 * An activity of the list of main topics.
 */
class TopicListActivity : BaseActivity() {
    override fun getActivityBuilder() = ActivityBuilder()
            .layoutId(R.layout.activity_layout)
            .toolbarTitle(getString(R.string.topics))
            .fragmentContainerId(R.id.fragment_container)
            .fragmentInstance(TopicListFragment())
}