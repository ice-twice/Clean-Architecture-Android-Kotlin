package com.architecture.clean.presentation.view.timer

import com.architecture.clean.R
import com.architecture.clean.presentation.view.base.activity.ActivityBuilder
import com.architecture.clean.presentation.view.base.activity.BaseActivity

/**
 * Timer activity.
 */
class TimerActivity : BaseActivity() {
    override fun getActivityBuilder() = ActivityBuilder()
            .layoutId(R.layout.activity_layout)
            .toolbarTitle(getString(R.string.timer))
            .fragmentContainerId(R.id.fragment_container)
            .fragmentInstance(TimerFragment())
}