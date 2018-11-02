package com.architecture.clean.presentation.activity

import androidx.fragment.app.Fragment
import com.architecture.clean.presentation.fragment.LoginFragment

/**
 * The login screen.
 */
class LoginActivity : BaseActivity() {
    override fun needSetContentView(): Boolean = false
    override fun layoutId(): Int = 0
    override fun fragmentContainerId(): Int = android.R.id.content
    override fun fragment(): Fragment = LoginFragment()
    override fun initializeToolbar(): Boolean = false
    override fun toolbarTitle(): String = ""
}