package com.architecture.clean.presentation.activity

import android.os.Bundle
import com.architecture.clean.R
import com.architecture.clean.presentation.fragment.TopicListFragment

/**
 * An activity of the list of main topics.
 */
class TopicListActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, TopicListFragment())
        }
    }
}