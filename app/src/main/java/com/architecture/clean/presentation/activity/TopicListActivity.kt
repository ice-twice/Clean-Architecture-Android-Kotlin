package com.architecture.clean.presentation.activity

import android.os.Bundle
import com.architecture.clean.presentation.fragment.TopicListFragment

/**
 * An activity of the list of main topics.
 */
class TopicListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            addFragment(android.R.id.content, TopicListFragment())
        }
    }
}