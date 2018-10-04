package com.architecture.clean.presentation.activity

import android.os.Bundle
import com.architecture.clean.R
import com.architecture.clean.presentation.fragment.LoginFragment

/**
 * A login screen.
 */
class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)

        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, LoginFragment())
        }
    }
}