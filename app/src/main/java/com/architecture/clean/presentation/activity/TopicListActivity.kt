package com.architecture.clean.presentation.activity

import android.os.Bundle
import android.view.MenuItem
import com.architecture.clean.R
import com.architecture.clean.presentation.fragment.TopicListFragment
import kotlinx.android.synthetic.main.toolbar.*

/**
 * An activity of the list of main topics.
 */
class TopicListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, TopicListFragment())
        }
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.topics)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}