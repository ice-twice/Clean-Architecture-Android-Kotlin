package com.architecture.clean.presentation.activity

import android.os.Bundle
import com.architecture.clean.presentation.fragment.LoginFragment

/**
 * The login screen.
 */
class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            addFragment(android.R.id.content, LoginFragment())
        }
    }
}