package com.architecture.clean.presentation.presenter

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 * The base presenter with supporting of the view lifecycle.
 */
abstract class BasePresenterViewLifecycle<V : Any> : BasePresenter<V>() {
    protected abstract var viewLifecycleObserver: LifecycleObserver

    fun initialize(view: V, viewLifecycleOwner: LifecycleOwner) {
        super.initialize(view)
        viewLifecycleOwner.lifecycle.addObserver(viewLifecycleObserver)
    }
}