package com.architecture.clean.presentation.navigation

import android.content.Context
import android.content.Intent
import com.architecture.clean.presentation.activity.TimerActivity
import com.architecture.clean.presentation.activity.TopicListActivity

/**
 * The navigator.
 */
class Navigator {
    /**
     * Show a view of the list of topics.
     */
    fun showTopicList(context: Context?) {
        context?.startActivity(Intent(context, TopicListActivity::class.java))
    }

    fun showCleanArchitectureView(context: Context?) {
        context?.startActivity(Intent(context, TimerActivity::class.java))
    }
}