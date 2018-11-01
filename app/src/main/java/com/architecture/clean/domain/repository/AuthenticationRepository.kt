package com.architecture.clean.domain.repository

import com.architecture.clean.domain.interactor.LoginInteractor
import io.reactivex.Completable

/**
 * The authentication interface.
 */
interface AuthenticationRepository {
    fun login(param: LoginInteractor.LoginParam): Completable
}