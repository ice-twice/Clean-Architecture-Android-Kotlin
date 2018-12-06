package com.architecture.clean.domain.interactor.abstractinteractor.adapter.stream

import com.architecture.clean.domain.interactor.abstractinteractor.adapter.observer.ObserverAdapter
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable

/**
 * The base adapter for different streams from the reactive library.
 * This class is used to create the base class for different streams.
 */
abstract class BaseStreamAdapter<Observer>{

    abstract fun subscribeOn(scheduler: Scheduler): BaseStreamAdapter<Observer>
    abstract fun observeOn(scheduler: Scheduler): BaseStreamAdapter<Observer>
    abstract fun subscribeWith(observerAdapter: ObserverAdapter<Observer>): Disposable
}