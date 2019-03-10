package com.architecture.clean.presentation.activity

import androidx.fragment.app.Fragment

class ActivityBuilder {
    var layoutId = 0
    var toolbarTitle: String? = null
    var fragmentContainerId = 0
    lateinit var fragmentInstance: Fragment

    fun layoutId(layoutId: Int) = apply { this.layoutId = layoutId }
    fun toolbarTitle(toolbarTitle: String?) = apply { this.toolbarTitle = toolbarTitle }
    fun fragmentContainerId(fragmentContainerId: Int) = apply { this.fragmentContainerId = fragmentContainerId }
    fun fragmentInstance(fragmentInstance: Fragment) = apply { this.fragmentInstance = fragmentInstance }
}