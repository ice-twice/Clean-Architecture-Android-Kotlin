package com.architecture.clean.domain.interactor

import com.architecture.clean.domain.interactor.abstractinteractor.CompletableInteractor
import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.domain.scheduler.PostExecutionScheduler
import io.reactivex.Completable
import io.reactivex.observers.DisposableCompletableObserver

/**
 * The login interactor.
 */
class LoginInteractor(override val backgroundScheduler: BackgroundScheduler, override val postExecutionScheduler: PostExecutionScheduler) : CompletableInteractor(backgroundScheduler, postExecutionScheduler) {

    /**
     * Handle the login operation.
     */
    fun login(login: String, password: String, disposableCompletableObserver: DisposableCompletableObserver) {
        println("CleanArchitecture : login - $login, password - $password")
        val completable = Completable.create { emitter ->
            Thread.sleep(5000)
            emitter.onComplete()
        }
        execute(completable, disposableCompletableObserver)
    }
}