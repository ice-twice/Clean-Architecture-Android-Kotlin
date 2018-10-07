package com.architecture.clean.presentation.view.presenter

import androidx.lifecycle.*
import com.architecture.clean.domain.interactor.LoginInteractor
import com.architecture.clean.presentation.view.fragment.interfaces.LoginView
import io.reactivex.observers.DisposableCompletableObserver
import javax.inject.Inject

/**
 * The Login presenter.
 */
class LoginPresenter @Inject constructor(private val loginInteractor: LoginInteractor) : BasePresenter<LoginView>(), LifecycleObserver {
    private val loginLiveData by lazy(mode = LazyThreadSafetyMode.NONE) {
        MutableLiveData<Boolean>()
    }
    private val loginLiveDataObserver by lazy(mode = LazyThreadSafetyMode.NONE) {
        Observer<Boolean> {
            isLogging = false
            view?.hideLoading()
            if (it) {
                view?.showMain()
            } else {
                view?.showLoginError()
            }
        }
    }

    private var isLogging = false

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    internal fun start() {
        if (isLogging) view?.showLoading()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    internal fun destroy() {
        loginInteractor.dispose()
    }

    /**
     * Handle a click oт the login button.
     */
    internal fun clickLoginButton(view: LoginView, login: String, password: String) {
        isLogging = true
        loginLiveData.observe(view as LifecycleOwner, loginLiveDataObserver)
        view.showLoading()
        loginInteractor.login(login, password, object : DisposableCompletableObserver() {
            override fun onComplete() {
                loginLiveData.value = true
            }

            override fun onError(e: Throwable) {
                loginLiveData.value = false
            }
        })
    }
}