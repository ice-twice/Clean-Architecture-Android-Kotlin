package com.architecture.clean.presentation.view.newslist

import com.architecture.clean.R
import com.architecture.clean.presentation.view.base.activity.ActivityBuilder
import com.architecture.clean.presentation.view.base.activity.BaseActivity

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