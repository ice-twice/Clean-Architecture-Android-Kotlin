package com.architecture.clean.presentation.view.presenter

/**
 * The base presenter class.
 */
open class BasePresenter<V> {
    protected var view: V? = null

    /**
     * Bind view to the presenter.
     * @param view the view.
     */
    fun bindView(view: V) {
        this.view = view
    }
}