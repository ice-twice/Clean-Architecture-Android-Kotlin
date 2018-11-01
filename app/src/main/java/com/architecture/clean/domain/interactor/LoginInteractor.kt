package com.architecture.clean.domain.interactor

import com.architecture.clean.domain.exception.WrongLoginOrPassword
import com.architecture.clean.domain.interactor.abstractinteractor.CompletableInteractor
import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.domain.scheduler.PostExecutionScheduler
import io.reactivex.Completable
import javax.inject.Inject

/**
 * The login interactor.
 */
class LoginInteractor @Inject constructor(override val backgroundScheduler: BackgroundScheduler, override val postExecutionScheduler: PostExecutionScheduler) : CompletableInteractor<LoginInteractor.LoginParam>(backgroundScheduler, postExecutionScheduler) {

    override fun create(param: LoginParam): Completable {
        return Completable.create { emitter ->
            try {
                Thread.sleep(2000)
            } catch (e: Exception) {
                // empty
            }
            if (param.login.isEmpty() && param.password.isEmpty()) {
                emitter.onComplete()
            } else {
                emitter.tryOnError(WrongLoginOrPassword())
            }
        }
    }

    class LoginParam(val login: String, val password: String)
}