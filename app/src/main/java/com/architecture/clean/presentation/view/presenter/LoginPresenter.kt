package com.architecture.clean.presentation.view.presenter

import com.architecture.clean.domain.interactor.LoginInteractor
import com.architecture.clean.presentation.view.fragment.interfaces.LoginView
import io.reactivex.observers.DisposableCompletableObserver
import javax.inject.Inject

/**
 * The Login presenter.
 */
class LoginPresenter @Inject constructor(private val loginInteractor: LoginInteractor) : BasePresenter() {

    /**
     * Handle a click oт the login button.
     */
    fun clickLoginButton(view: LoginView, login: String, password: String) {
        // need to show progress
        view.showLoading()
        loginInteractor.login(login, password, object : DisposableCompletableObserver() {
            override fun onComplete() {
                view.hideLoading()
            }

            override fun onError(e: Throwable) {
                view.hideLoading()
            }
        })
    }

    public override fun onDestroy() {
        loginInteractor.dispose()
    }
}