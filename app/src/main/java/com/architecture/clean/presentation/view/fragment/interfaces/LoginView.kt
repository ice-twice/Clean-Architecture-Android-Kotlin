package com.architecture.clean.presentation.view.fragment.interfaces

import com.architecture.clean.presentation.view.fragment.interfaces.component.ProgressInterface

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
}