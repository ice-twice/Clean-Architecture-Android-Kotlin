package com.architecture.clean.domain.interactor.abstractinteractor

import com.architecture.clean.domain.News
import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.domain.scheduler.PostExecutionScheduler
import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver

/**
 * The abstract Single interactor.
 */
abstract class SingleInteractor<Param>(override val backgroundScheduler: BackgroundScheduler, override val postExecutionScheduler: PostExecutionScheduler) : BaseInteractor<Single<List<News>>, Param>(backgroundScheduler, postExecutionScheduler) {

    /**
     * Execute the operation.
     */
    fun execute(param: Param, disposableSingleObserver: DisposableSingleObserver<List<News>>) {
        val newSingle = create(param)
                .subscribeOn(backgroundScheduler.scheduler)
                .observeOn(postExecutionScheduler.scheduler)

        val disposableObserver = newSingle.subscribeWith(disposableSingleObserver)
        compositeDisposable.add(disposableObserver)
    }
}