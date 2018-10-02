package com.architecture.clean.domain.interactor.abstractinteractor

import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.domain.scheduler.PostExecutionScheduler
import io.reactivex.Completable
import io.reactivex.observers.DisposableCompletableObserver

/**
 * Abstract class for Completable.
 */
abstract class CompletableInteractor(override val backgroundScheduler: BackgroundScheduler, override val postExecutionScheduler: PostExecutionScheduler) : BaseInteractor(backgroundScheduler, postExecutionScheduler) {

    /**
     * Execute the operation.
     */
    fun execute(completable: Completable, disposableCompletableObserver: DisposableCompletableObserver) {
        val newCompletable = completable.subscribeOn(backgroundScheduler.scheduler)
                .observeOn(postExecutionScheduler.scheduler)

        val disposableObserver = newCompletable.subscribeWith(disposableCompletableObserver)
        compositeDisposable.add(disposableObserver)
    }
}