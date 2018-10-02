package com.architecture.clean.domain

import android.os.AsyncTask
import android.util.Log

/**
 * The login interactor.
 */
// todo remove async task
class LoginInteractor {
    private var loginTask: UserLoginTask? = null

    /**
     * The login operation.
     */
    fun login(login: String, password: String) {
        loginTask = UserLoginTask(login, password)
        loginTask!!.execute(null)
    }

    class UserLoginTask internal constructor(private val login: String, private val password: String) : AsyncTask<Void, Void, Boolean>() {
        override fun doInBackground(vararg params: Void): Boolean? {
            try {
                Thread.sleep(2000)
            } catch (e: InterruptedException) {
                return false
            }

            Log.d("CleanArchitecture", "login - $login, password - $password")
            return false
        }
    }
}