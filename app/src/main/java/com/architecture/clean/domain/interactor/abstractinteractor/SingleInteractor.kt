package com.architecture.clean.domain.interactor.abstractinteractor

import com.architecture.clean.domain.interactor.abstractinteractor.adapter.stream.StreamAdapterSingle
import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.domain.scheduler.PostExecutionScheduler
import io.reactivex.observers.DisposableSingleObserver

/**
 * The abstract Single interactor.
 */
abstract class SingleInteractor<Param, T>(override val backgroundScheduler: BackgroundScheduler, override val postExecutionScheduler: PostExecutionScheduler) : BaseInteractor<Param, DisposableSingleObserver<T>, StreamAdapterSingle<T>>(backgroundScheduler, postExecutionScheduler)