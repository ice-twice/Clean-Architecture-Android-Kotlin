package com.architecture.clean.domain.interactor

import com.architecture.clean.domain.interactor.abstractinteractor.CompletableInteractor
import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.domain.scheduler.PostExecutionScheduler
import io.reactivex.Completable

/**
 * The login interactor.
 */
class LoginInteractor(override val backgroundScheduler: BackgroundScheduler, override val postExecutionScheduler: PostExecutionScheduler) : CompletableInteractor<Array<String>>(backgroundScheduler, postExecutionScheduler) {

    override fun createCompletable(param: Array<String>): Completable {
        println("CleanArchitecture : login - ${param[0]}, password - ${param[1]}")
        return Completable.create { emitter ->
            Thread.sleep(5000)
            emitter.onComplete()
        }
    }
}