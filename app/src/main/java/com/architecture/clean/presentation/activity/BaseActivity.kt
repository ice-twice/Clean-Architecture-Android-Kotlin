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
    abstract fun getActivityBuilder(): ActivityBuilder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityBuilder = getActivityBuilder()
        if (activityBuilder.layoutId != 0) {
            setContentView(activityBuilder.layoutId)
        }

        if (!activityBuilder.toolbarTitle.isNullOrEmpty()) {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = activityBuilder.toolbarTitle
        }

        if (savedInstanceState == null && activityBuilder.fragmentContainerId != 0) {
            addFragment(activityBuilder.fragmentContainerId, activityBuilder.fragmentInstance)
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
    private fun addFragment(containerId: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(containerId, fragment)
                .commit()
    }
}