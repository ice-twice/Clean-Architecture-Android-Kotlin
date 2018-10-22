package com.architecture.clean.presentation.interfaces.component

/**
 *  The hide/show progress interface.
 */
interface ProgressInterface {
    /**
     * Show loading state.
     */
    fun showLoading()

    /**
     * Hide loading state.
     */
    fun hideLoading()
}