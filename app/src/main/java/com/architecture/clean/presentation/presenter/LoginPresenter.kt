package com.architecture.clean.presentation.presenter

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.lifecycle.OnLifecycleEvent
import com.architecture.clean.domain.exception.InternetConnectionIsNotAvailableException
import com.architecture.clean.domain.exception.WrongLoginOrPasswordException
import com.architecture.clean.domain.interactor.LoginInteractor
import com.architecture.clean.domain.interactor.abstractinteractor.adapter.observer.ObserverAdapter
import com.architecture.clean.presentation.component.StoppableLiveData
import com.architecture.clean.presentation.interfaces.LoginView
import com.architecture.clean.presentation.presenter.base.BasePresenterViewAndLayoutLifecycle
import io.reactivex.observers.DisposableCompletableObserver
import javax.inject.Inject

/**
 * The Login presenter.
 *
 * Live data is used in the presenter to respect the lifecycle of a view.
 */
class LoginPresenter @Inject constructor(private val loginInteractor: LoginInteractor) : BasePresenterViewAndLayoutLifecycle<LoginView>(), LifecycleObserver {
    override var viewLifecycleObserver: LifecycleObserver = ViewLifecycleObserver()
    override var viewLayoutLifecycleObserver: LifecycleObserver = ViewLayoutLifecycleObserver()

    /**
     * This class is used to handle the view lifecycle.
     */
    protected inner class ViewLifecycleObserver : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun destroy() {
            loginInteractor.dispose()
        }
    }

    /**
     * This class is used to handle the layout lifecycle.
     *
     * This is useful to restore the view state after changing the screen orientation.
     */
    protected inner class ViewLayoutLifecycleObserver : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun create() {
            loginLoadingLiveEvent.observe(viewLayoutLifecycleOwner, Observer {
                if (it) {
                    view.showLoading()
                } else {
                    view.hideLoading()
                }
            })

            loginFailureLiveEvent.observe(viewLayoutLifecycleOwner, Observer {
                when (it) {
                    is WrongLoginOrPasswordException -> view.showLoginParamError()
                    is InternetConnectionIsNotAvailableException -> view.showInternetIsNotAvailableError()
                }
            })

            loginSuccessLiveEvent.observe(viewLayoutLifecycleOwner, Observer {
                view.showMain()
            })
        }
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
        view.hideKeyboard()
        loginLoadingLiveEvent.value(true)
        loginFailureLiveEvent.stopped = true
        loginInteractor.execute(LoginInteractor.LoginParam(login, password), ObserverAdapter(object : DisposableCompletableObserver() {
            override fun onComplete() {
                loginSuccessLiveEvent.value(null).stopped = true
                loginLoadingLiveEvent.value(false).stopped = true
            }

            override fun onError(e: Throwable) {
                loginLoadingLiveEvent.value(false).stopped = true
                loginFailureLiveEvent.value(e)
            }
        }))
    }
}