package com.architecture.clean.view.activity

import android.os.Bundle
import com.architecture.clean.R
import com.architecture.clean.view.fragment.LoginFragment

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