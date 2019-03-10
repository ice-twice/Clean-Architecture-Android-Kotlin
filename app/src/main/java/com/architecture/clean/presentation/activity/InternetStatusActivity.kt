package com.architecture.clean.presentation.activity

import com.architecture.clean.R
import com.architecture.clean.presentation.fragment.InternetStatusFragment

/**
 * The internet status activity.
 */
class InternetStatusActivity : BaseActivity() {
    override fun getActivityBuilder() = ActivityBuilder()
            .layoutId(R.layout.activity_layout)
            .toolbarTitle(getString(R.string.internet_status))
            .fragmentContainerId(R.id.fragment_container)
            .fragmentInstance(InternetStatusFragment())
}