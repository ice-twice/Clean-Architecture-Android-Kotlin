package com.architecture.clean.presentation.view.base.presenter

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner

abstract class BasePresenterViewAndLayoutLifecycle<V : Any> : BasePresenterViewLifecycle<V>() {
    protected lateinit var viewLayoutLifecycleOwner: LifecycleOwner
    protected abstract var viewLayoutLifecycleObserver: LifecycleObserver

    fun initialize(view: V, viewLifecycleOwner: LifecycleOwner, viewLayoutLifecycleOwner: LifecycleOwner) {
        super.initialize(view, viewLifecycleOwner)
        this.viewLayoutLifecycleOwner = viewLayoutLifecycleOwner
        viewLayoutLifecycleOwner.lifecycle.addObserver(viewLayoutLifecycleObserver)
    }
}