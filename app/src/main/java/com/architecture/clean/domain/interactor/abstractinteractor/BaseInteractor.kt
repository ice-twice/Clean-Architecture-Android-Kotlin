package com.architecture.clean.domain.interactor.abstractinteractor

import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.domain.scheduler.PostExecutionScheduler
import io.reactivex.disposables.CompositeDisposable

/**
 * Abstract interactor.
 */
abstract class BaseInteractor<Stream, Param>(protected open val backgroundScheduler: BackgroundScheduler, protected open val postExecutionScheduler: PostExecutionScheduler) {
    protected val compositeDisposable: CompositeDisposable by lazy(mode = LazyThreadSafetyMode.NONE) {
        CompositeDisposable()
    }

    /**
     * Create a flow.
     */
    protected abstract fun create(param: Param): Stream

    /**
     * Cancel operations and dispose resources.
     */
    fun dispose() {
        compositeDisposable.dispose()
    }
}