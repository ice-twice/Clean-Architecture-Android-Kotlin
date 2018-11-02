package com.architecture.clean.data

import android.content.Context
import com.architecture.clean.domain.exception.InternetConnectionIsNotAvailableException
import com.architecture.clean.domain.exception.WrongLoginOrPasswordException
import com.architecture.clean.domain.interactor.LoginInteractor
import com.architecture.clean.domain.repository.AuthenticationRepository
import com.architecture.clean.presentation.util.AndroidUtil
import io.reactivex.Completable
import javax.inject.Inject

/**
 * The authentication repository.
 */
class AuthenticationRepositoryImpl @Inject constructor(val context: Context, private val androidUtil: AndroidUtil) : AuthenticationRepository {
    override fun login(param: LoginInteractor.LoginParam): Completable {
        var completable: Completable? = null
        when (androidUtil.isInternetConnection(context)) {
            true -> {
                completable = Completable.create { emitter ->
                    try {
                        Thread.sleep(1000)
                    } catch (e: Exception) {
                        // empty
                    }
                    if (param.login.isEmpty() && param.password.isEmpty()) {
                        emitter.onComplete()
                    } else {
                        emitter.tryOnError(WrongLoginOrPasswordException())
                    }
                }
            }
            false -> {
                completable = Completable.error(InternetConnectionIsNotAvailableException())
            }
        }
        return completable
    }
}
