package com.architecture.clean.presentation.presenter

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 * The base presenter class.
 */
abstract class BasePresenter<V : Any> {
    protected lateinit var view: V
    protected lateinit var viewLayoutLifecycleOwner: LifecycleOwner
    protected open var viewLifecycleObserver: LifecycleObserver? = null
    protected open var viewLayoutLifecycleObserver: LifecycleObserver? = null

    fun initialize(view: V, viewLifecycleOwner: LifecycleOwner, viewLayoutLifecycleOwner: LifecycleOwner) {
        this.view = view
        viewLifecycleObserver?.let { viewLifecycleOwner.lifecycle.addObserver(it) }
        this.viewLayoutLifecycleOwner = viewLayoutLifecycleOwner
        viewLayoutLifecycleObserver?.let { viewLayoutLifecycleOwner.lifecycle.addObserver(it) }
    }
}