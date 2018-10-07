package com.architecture.clean.domain.interactor

import com.architecture.clean.domain.exception.WrongLoginOrPassword
import com.architecture.clean.domain.interactor.abstractinteractor.CompletableInteractor
import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.domain.scheduler.PostExecutionScheduler
import io.reactivex.Completable
import io.reactivex.observers.DisposableCompletableObserver
import javax.inject.Inject

/**
 * The login interactor.
 */
class LoginInteractor @Inject constructor(override val backgroundScheduler: BackgroundScheduler, override val postExecutionScheduler: PostExecutionScheduler) : CompletableInteractor(backgroundScheduler, postExecutionScheduler) {

    /**
     * Handle the login operation.
     */
    fun login(login: String, password: String, disposableCompletableObserver: DisposableCompletableObserver) {
        val completable = Completable.create { emitter ->
            try {
                Thread.sleep(5000)
            } catch (e: Exception) {
                // empty
            }
            if (login.isEmpty() && password.isEmpty()) {
                emitter.onComplete()
            } else {
                emitter.tryOnError(WrongLoginOrPassword())
            }
        }
        execute(completable, disposableCompletableObserver)
    }
}