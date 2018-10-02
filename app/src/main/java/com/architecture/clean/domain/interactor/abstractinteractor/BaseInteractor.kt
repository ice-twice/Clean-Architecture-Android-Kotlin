package com.architecture.clean.domain.interactor.abstractinteractor

import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.domain.scheduler.PostExecutionScheduler

/**
 * Abstract interactor.
 */
abstract class BaseInteractor(protected open val backgroundScheduler: BackgroundScheduler, protected open val postExecutionScheduler: PostExecutionScheduler)