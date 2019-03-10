package com.architecture.clean.presentation.activity

import com.architecture.clean.R
import com.architecture.clean.presentation.fragment.TimerFragment

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