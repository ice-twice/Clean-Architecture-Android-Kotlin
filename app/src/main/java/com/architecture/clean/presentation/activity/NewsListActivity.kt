package com.architecture.clean.presentation.activity

import com.architecture.clean.R
import com.architecture.clean.presentation.fragment.NewsListFragment

/**
 * The news list activity.
 */
class NewsListActivity : BaseActivity() {
    override fun getActivityBuilder() = ActivityBuilder()
            .layoutId(R.layout.activity_layout)
            .toolbarTitle(getString(R.string.news))
            .fragmentContainerId(R.id.fragment_container)
            .fragmentInstance(NewsListFragment())
}