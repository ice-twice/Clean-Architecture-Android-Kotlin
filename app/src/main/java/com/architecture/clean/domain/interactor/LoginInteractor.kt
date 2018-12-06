package com.architecture.clean.domain.interactor

import com.architecture.clean.domain.interactor.abstractinteractor.CompletableInteractor
import com.architecture.clean.domain.interactor.abstractinteractor.adapter.stream.StreamAdapterCompletable
import com.architecture.clean.domain.repository.AuthenticationRepository
import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.domain.scheduler.PostExecutionScheduler
import javax.inject.Inject

/**
 * The login interactor.
 */
class LoginInteractor @Inject constructor(override val backgroundScheduler: BackgroundScheduler, override val postExecutionScheduler: PostExecutionScheduler, private val authenticationRepository: AuthenticationRepository) : CompletableInteractor<LoginInteractor.LoginParam>(backgroundScheduler, postExecutionScheduler) {

    override fun create(param: LoginParam): StreamAdapterCompletable = StreamAdapterCompletable(authenticationRepository.login(param))

    data class LoginParam(val login: String, val password: String)
}