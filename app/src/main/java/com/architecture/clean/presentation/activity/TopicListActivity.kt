package com.architecture.clean.presentation.activity

import androidx.fragment.app.Fragment
import com.architecture.clean.R
import com.architecture.clean.presentation.fragment.TopicListFragment

/**
 * An activity of the list of main topics.
 */
class TopicListActivity : BaseActivity() {
    override fun needSetContentView(): Boolean = true
    override fun layoutId(): Int = R.layout.activity_layout
    override fun fragmentContainerId(): Int = R.id.fragment_container
    override fun fragment(): Fragment = TopicListFragment()
    override fun initializeToolbar(): Boolean = true
    override fun toolbarTitle(): String = getString(R.string.topics)
}