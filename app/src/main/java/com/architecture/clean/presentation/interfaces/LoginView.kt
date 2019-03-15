package com.architecture.clean.presentation.interfaces

import com.architecture.clean.presentation.view.base.interfaces.component.ProgressInterface

/**
 * The login interface.
 */
interface LoginView : ProgressInterface {
    /**
     * Show the login error.
     */
    fun showLoginParamError()

    /**
     * Show the main screen.
     */
    fun showMain()

    /**
     * Hide the keyboard.
     */
    fun hideKeyboard()

    /**
     * Show show internet is not available error.
     */
    fun showInternetIsNotAvailableError()
}