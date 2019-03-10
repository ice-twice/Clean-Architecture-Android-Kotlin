package com.architecture.clean.presentation.activity

import com.architecture.clean.presentation.fragment.LoginFragment

/**
 * The login screen.
 */
class LoginActivity : BaseActivity() {
    override fun getActivityBuilder() = ActivityBuilder()
            .layoutId(0)
            .toolbarTitle(null)
            .fragmentContainerId(android.R.id.content)
            .fragmentInstance(LoginFragment())
}