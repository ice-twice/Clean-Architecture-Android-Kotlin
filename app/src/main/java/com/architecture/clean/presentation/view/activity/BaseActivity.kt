package com.architecture.clean.presentation.view.activity

import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity

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