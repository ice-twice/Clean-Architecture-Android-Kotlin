package com.architecture.clean.view.presenter

import com.architecture.clean.domain.LoginInteractor
import com.architecture.clean.view.fragment.interfaces.LoginView
import io.reactivex.observers.DisposableCompletableObserver

/**
 * The Login presenter.
 */
class LoginPresenter {
    private val loginInteractor = LoginInteractor()

    /**
     * Handle a click oт the login button.
     */
    fun clickLoginButton(view: LoginView, login: String, password: String) {
        // need to show progress
        view.showLoading()
        loginInteractor.login(login, password)
                ?.subscribeWith(object : DisposableCompletableObserver() {
            override fun onComplete() {
                view.hideLoading()
            }

            override fun onError(e: Throwable) {
                view.hideLoading()
            }
        })
    }
}