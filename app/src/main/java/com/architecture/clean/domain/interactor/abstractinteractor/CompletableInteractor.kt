package com.architecture.clean.domain.interactor.abstractinteractor

import com.architecture.clean.domain.interactor.abstractinteractor.adapter.stream.StreamAdapterCompletable
import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.domain.scheduler.PostExecutionScheduler
import io.reactivex.observers.DisposableCompletableObserver

/**
 * Abstract class for Completable.
 */
abstract class CompletableInteractor<Param>(override val backgroundScheduler: BackgroundScheduler, override val postExecutionScheduler: PostExecutionScheduler) : BaseInteractor<Param, DisposableCompletableObserver, StreamAdapterCompletable>(backgroundScheduler, postExecutionScheduler)