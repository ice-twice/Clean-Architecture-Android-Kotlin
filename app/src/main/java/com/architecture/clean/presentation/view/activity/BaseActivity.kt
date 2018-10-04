package com.architecture.clean.presentation.view.activity

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Abstract activity.
 */
abstract class BaseActivity : AppCompatActivity() {

    /**
     * @param containerId the id of a view where the fragment will be added.
     * @param fragment    an instance of a fragment to add.
     */
    protected fun addFragment(containerId: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(containerId, fragment)
                .commit()
    }
}