package com.architecture.clean.presentation.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Abstract activity.
 */
abstract class BaseActivity : AppCompatActivity() {
    abstract fun needSetContentView(): Boolean
    abstract fun layoutId(): Int
    abstract fun fragmentContainerId(): Int
    abstract fun fragment(): Fragment
    abstract fun initializeToolbar(): Boolean
    abstract fun toolbarTitle(): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (needSetContentView()) {
            setContentView(layoutId())
        }

        if (savedInstanceState == null) {
            addFragment(fragmentContainerId(), fragment())
        }

        if (initializeToolbar()) {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = toolbarTitle()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

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