package com.architecture.clean.presentation.view.presenter

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.architecture.clean.domain.interactor.LoginInteractor
import com.architecture.clean.presentation.view.fragment.interfaces.LoginView
import io.reactivex.observers.DisposableCompletableObserver
import javax.inject.Inject

/**
 * The Login presenter.
 */
class LoginPresenter @Inject constructor(private val loginInteractor: LoginInteractor) : BasePresenter(), LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    internal fun destroy() {
        loginInteractor.dispose()
    }

    /**
     * Handle a click oт the login button.
     */
    internal fun clickLoginButton(view: LoginView, login: String, password: String) {
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
}