package com.architecture.clean.presentation.view.presenter

import androidx.lifecycle.*
import com.architecture.clean.domain.exception.WrongLoginOrPassword
import com.architecture.clean.domain.interactor.LoginInteractor
import com.architecture.clean.presentation.view.fragment.interfaces.LoginView
import io.reactivex.observers.DisposableCompletableObserver
import javax.inject.Inject

/**
 * The Login presenter.
 */
class LoginPresenter @Inject constructor(private val loginInteractor: LoginInteractor) : BasePresenter<LoginView>(), LifecycleObserver {
    private val loginLoadingLiveEvent by lazy(mode = LazyThreadSafetyMode.NONE) {
        MutableLiveData<Boolean>()
    }
    private val loginSuccessLiveEvent by lazy(mode = LazyThreadSafetyMode.NONE) {
        MutableLiveData<Void>()
    }
    private val loginFailureLiveEvent by lazy(mode = LazyThreadSafetyMode.NONE) {
        MutableLiveData<Throwable>()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    internal fun start() {
        loginLoadingLiveEvent.observe(lifecycleOwner, Observer<Boolean> {
            if (it) {
                view.showLoading()
            } else {
                view.hideLoading()
            }
        })
        loginFailureLiveEvent.observe(lifecycleOwner, Observer<Throwable> {
            if (it is WrongLoginOrPassword) {
                view.showLoginError()
            }
        })
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    internal fun destroy() {
        loginInteractor.dispose()
    }

    /**
     * Handle a click oт the login button.
     */
    internal fun clickLoginButton(login: String, password: String) {
        loginSuccessLiveEvent.observe(lifecycleOwner, Observer<Void> {
            view.showMain()
        })
        loginLoadingLiveEvent.value = true
        loginInteractor.login(login, password, object : DisposableCompletableObserver() {
            override fun onComplete() {
                loginLoadingLiveEvent.value = false
                loginSuccessLiveEvent.value = null
            }

            override fun onError(e: Throwable) {
                loginLoadingLiveEvent.value = false
                loginFailureLiveEvent.value = e
            }
        })
    }
}