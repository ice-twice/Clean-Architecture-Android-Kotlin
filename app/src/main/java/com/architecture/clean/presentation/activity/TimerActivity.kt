package com.architecture.clean.presentation.activity

import androidx.fragment.app.Fragment
import com.architecture.clean.R
import com.architecture.clean.presentation.fragment.TimerFragment

/**
 * Timer activity.
 */
class TimerActivity : BaseActivity() {
    override fun needSetContentView(): Boolean = true
    override fun layoutId(): Int = R.layout.activity_layout
    override fun fragmentContainerId(): Int = R.id.fragment_container
    override fun fragment(): Fragment = TimerFragment()
    override fun initializeToolbar(): Boolean = true
    override fun toolbarTitle(): String = getString(R.string.timer)
}