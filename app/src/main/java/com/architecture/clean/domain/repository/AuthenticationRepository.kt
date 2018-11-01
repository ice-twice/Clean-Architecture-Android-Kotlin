package com.architecture.clean.domain.repository

import com.architecture.clean.domain.exception.WrongLoginOrPassword
import com.architecture.clean.domain.interactor.LoginInteractor
import io.reactivex.Completable
import javax.inject.Inject

/**
 * The authentication repository.
 */
class AuthenticationRepository @Inject constructor() {
    fun login(param: LoginInteractor.LoginParam): Completable {
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
}