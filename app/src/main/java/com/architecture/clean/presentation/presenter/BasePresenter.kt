package com.architecture.clean.presentation.presenter

import androidx.lifecycle.LifecycleOwner

/**
 * The base presenter class.
 */
open class BasePresenter<V : Any> {
    protected lateinit var view: V
    protected lateinit var lifecycleOwner: LifecycleOwner

    /**
     * Bind view to the presenter.
     * @param view the view.
     */
    fun bindView(view: V, lifecycleOwner: LifecycleOwner) {
        this.view = view
        this.lifecycleOwner = lifecycleOwner
    }
}