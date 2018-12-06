package com.architecture.clean.domain.interactor.abstractinteractor

import com.architecture.clean.domain.interactor.abstractinteractor.adapter.observer.ObserverAdapter
import com.architecture.clean.domain.interactor.abstractinteractor.adapter.stream.BaseStreamAdapter
import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.domain.scheduler.PostExecutionScheduler
import io.reactivex.disposables.CompositeDisposable

/**
 * Abstract interactor.
 */
abstract class BaseInteractor<Param, Observer, StreamAdapter : BaseStreamAdapter<Observer>>(protected open val backgroundScheduler: BackgroundScheduler, protected open val postExecutionScheduler: PostExecutionScheduler) {

    private val compositeDisposable: CompositeDisposable by lazy(mode = LazyThreadSafetyMode.NONE) {
        CompositeDisposable()
    }

    /**
     * Create a flow.
     */
    protected abstract fun create(param: Param): StreamAdapter

    /**
     * Cancel operations and dispose resources.
     */
    fun dispose() {
        compositeDisposable.dispose()
    }

    fun execute(param: Param, observerAdapter: ObserverAdapter<Observer>) {
        val streamAdapter = create(param)
                .subscribeOn(backgroundScheduler.scheduler)
                .observeOn(postExecutionScheduler.scheduler)
        compositeDisposable.add(streamAdapter.subscribeWith(observerAdapter))
    }
}