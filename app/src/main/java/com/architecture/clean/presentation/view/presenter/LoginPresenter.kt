package com.architecture.clean.presentation.view.presenter

import androidx.lifecycle.*
import com.architecture.clean.domain.exception.WrongLoginOrPassword
import com.architecture.clean.domain.interactor.LoginInteractor
import com.architecture.clean.presentation.view.component.StoppableLiveData
import com.architecture.clean.presentation.view.fragment.interfaces.LoginView
import io.reactivex.observers.DisposableCompletableObserver
import javax.inject.Inject

/**
 * The Login presenter.
 */
class LoginPresenter @Inject constructor(private val loginInteractor: LoginInteractor) : BasePresenter<LoginView>(), LifecycleObserver {
    val viewLifecycleObserver by lazy(mode = LazyThreadSafetyMode.NONE) {
        ViewLifecycleObserver()
    }

    val viewLayoutLifecycleObserver by lazy(mode = LazyThreadSafetyMode.NONE) {
        ViewLayoutLifecycleObserver()
    }

    private val loginLoadingLiveEvent by lazy(mode = LazyThreadSafetyMode.NONE) {
        StoppableLiveData<Boolean>()
    }

    private val loginSuccessLiveEvent by lazy(mode = LazyThreadSafetyMode.NONE) {
        StoppableLiveData<Void>()
    }

    private val loginFailureLiveEvent by lazy(mode = LazyThreadSafetyMode.NONE) {
        StoppableLiveData<Throwable>()
    }

    /**
     * Handle a click oт the login button.
     */
    internal fun clickLoginButton(login: String, password: String) {
        loginLoadingLiveEvent.value(true)
        loginFailureLiveEvent.stopped = true
        loginInteractor.login(login, password, object : DisposableCompletableObserver() {
            override fun onComplete() {
                loginSuccessLiveEvent.value(null).stopped = true
                loginLoadingLiveEvent.value(false).stopped = true
            }

            override fun onError(e: Throwable) {
                loginLoadingLiveEvent.value(false).stopped = true
                loginFailureLiveEvent.value(e)
            }
        })
    }

    inner class ViewLifecycleObserver : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun destroy() {
            loginInteractor.dispose()
        }
    }

    inner class ViewLayoutLifecycleObserver : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun create() {
            loginLoadingLiveEvent.observe(lifecycleOwner, Observer {
                if (it) {
                    view.showLoading()
                } else {
                    view.hideLoading()
                }
            })

            loginFailureLiveEvent.observe(lifecycleOwner, Observer {
                if (it is WrongLoginOrPassword) {
                    view.showLoginError()
                }
            })

            loginSuccessLiveEvent.observe(lifecycleOwner, Observer {
                view.showMain()
            })
        }
    }
}