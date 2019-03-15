package com.architecture.clean.presentation.navigation

import android.content.Context
import android.content.Intent
import com.architecture.clean.presentation.view.internetstatus.InternetStatusActivity
import com.architecture.clean.presentation.view.newslist.NewsListActivity
import com.architecture.clean.presentation.view.timer.TimerActivity

/**
 * The navigator.
 */
class Navigator {

    /**
     * Show the clean architecture view.
     */
    fun showCleanArchitectureView(context: Context?) {
        context?.startActivity(Intent(context, TimerActivity::class.java))
    }

    /**
     * Show the clean architecture advantages view.
     */
    fun showCleanArchitectureAdvantagesView(context: Context?) {
        context?.startActivity(Intent(context, InternetStatusActivity::class.java))
    }

    /**
     * Show the news list activity.
     */
    fun showNewsListView(context: Context?) {
        context?.startActivity(Intent(context, NewsListActivity::class.java))
    }
}