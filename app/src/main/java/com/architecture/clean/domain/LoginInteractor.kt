package com.architecture.clean.domain

import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * The login interactor.
 */
class LoginInteractor {
    /**
     * The login operation.
     */
    fun login(login: String, password: String): Completable? {
        return Completable.create { emitter ->
            Thread.sleep(5000)
            emitter.onComplete()
        }
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }
}