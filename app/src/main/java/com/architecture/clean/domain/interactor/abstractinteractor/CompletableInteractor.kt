package com.architecture.clean.domain.interactor.abstractinteractor

import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.domain.scheduler.PostExecutionScheduler
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableCompletableObserver

/**
 * Abstract class for Completable.
 */
abstract class CompletableInteractor<Param>(override val backgroundScheduler: BackgroundScheduler, override val postExecutionScheduler: PostExecutionScheduler) : BaseInteractor(backgroundScheduler, postExecutionScheduler) {
    private val compositeDisposable = CompositeDisposable()

    /**
     * Execute operation.
     */
    fun execute(disposableCompletableObserver: DisposableCompletableObserver, param: Param) {
        val completable = createCompletable(param)
                .subscribeOn(backgroundScheduler.scheduler)
                .observeOn(postExecutionScheduler.scheduler)

        val disposableObserver = completable.subscribeWith(disposableCompletableObserver)
        compositeDisposable.add(disposableObserver)
    }

    /**
     * Create completable.
     */
    protected abstract fun createCompletable(param: Param): Completable

    /**
     * Cancel operations and dispose resources.
     */
    fun dispose() {
        compositeDisposable.dispose()
    }
}