package com.architecture.clean.domain.interactor.abstractinteractor.adapter.stream

import com.architecture.clean.domain.interactor.abstractinteractor.adapter.observer.ObserverAdapter
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableCompletableObserver

/**
 * The completable adapter.
 */

class StreamAdapterCompletable(private val completable: Completable) : BaseStreamAdapter<DisposableCompletableObserver>() {

    override fun subscribeOn(scheduler: Scheduler): BaseStreamAdapter<DisposableCompletableObserver> {
        return StreamAdapterCompletable(completable.subscribeOn(scheduler))
    }

    override fun observeOn(scheduler: Scheduler): BaseStreamAdapter<DisposableCompletableObserver> {
        return StreamAdapterCompletable(completable.observeOn(scheduler))
    }

    override fun subscribeWith(observerAdapter: ObserverAdapter<DisposableCompletableObserver>): Disposable {
        return completable.subscribeWith(observerAdapter.observer)
    }
}