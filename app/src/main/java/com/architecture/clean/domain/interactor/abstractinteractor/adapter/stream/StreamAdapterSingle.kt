package com.architecture.clean.domain.interactor.abstractinteractor.adapter.stream

import com.architecture.clean.domain.interactor.abstractinteractor.adapter.observer.ObserverAdapter
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver


class StreamAdapterSingle<T>(private val single: Single<T>) : BaseStreamAdapter<DisposableSingleObserver<T>>() {
    override fun subscribeOn(scheduler: Scheduler): BaseStreamAdapter<DisposableSingleObserver<T>> {
        return StreamAdapterSingle(single.subscribeOn(scheduler))
    }

    override fun observeOn(scheduler: Scheduler): BaseStreamAdapter<DisposableSingleObserver<T>> {
        return StreamAdapterSingle(single.observeOn(scheduler))
    }

    override fun subscribeWith(observerAdapter: ObserverAdapter<DisposableSingleObserver<T>>): Disposable {
        return single.subscribeWith(observerAdapter.observer)
    }
}