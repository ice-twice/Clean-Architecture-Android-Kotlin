package com.architecture.clean.presentation.presenter

import com.architecture.clean.domain.interactor.LoginInteractor
import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.domain.scheduler.PostExecutionScheduler
import com.architecture.clean.presentation.fragment.interfaces.LoginView
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers

/**
 * The Login presenter.
 */
class LoginPresenter : BasePresenter() {
    private val loginInteractor = LoginInteractor(object : BackgroundScheduler {
        override val scheduler: Scheduler
            get() = Schedulers.io()
    }, object : PostExecutionScheduler {
        override val scheduler: Scheduler
            get() = AndroidSchedulers.mainThread()
    })

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