package com.architecture.clean.presentation.presenter.base

/**
 * The base presenter class.
 */
abstract class BasePresenter<V : Any> {
    protected lateinit var view: V

    fun initialize(view: V) {
        this.view = view
    }
}