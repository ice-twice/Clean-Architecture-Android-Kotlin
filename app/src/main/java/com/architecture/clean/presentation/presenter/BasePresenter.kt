package com.architecture.clean.presentation.presenter

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 * The base presenter class.
 */
abstract class BasePresenter<V : Any> {
    lateinit var view: V
    internal lateinit var viewLayoutLifecycleOwner: LifecycleOwner
    protected open var viewLifecycleObserver = object : LifecycleObserver {}
    protected open var viewLayoutLifecycleObserver = object : LifecycleObserver {}

    fun observeViewLifecycle(viewLifecycleOwner: LifecycleOwner) {
        viewLifecycleOwner.lifecycle.addObserver(viewLifecycleObserver)
    }

    fun setViewLayoutLifecycleAndObserve(viewLayoutLifecycleOwner: LifecycleOwner) {
        this.viewLayoutLifecycleOwner = viewLayoutLifecycleOwner
        viewLayoutLifecycleOwner.lifecycle.addObserver(viewLayoutLifecycleObserver)
    }
}