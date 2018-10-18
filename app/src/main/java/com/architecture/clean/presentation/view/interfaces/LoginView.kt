package com.architecture.clean.presentation.view.interfaces

import com.architecture.clean.presentation.view.interfaces.component.ProgressInterface

/**
 * The login interface.
 */
interface LoginView : ProgressInterface {
    /**
     * Show the login error.
     */
    fun showLoginError()

    /**
     * Show the main screen.
     */
    fun showMain()

    /**
     * Hide the keyboard.
     */
    fun hideKeyboard()
}