package com.architecture.clean.presentation.service

import android.app.IntentService
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.architecture.clean.presentation.di.component.DaggerTimerServiceComponent
import com.architecture.clean.presentation.interfaces.TimerServiceView
import com.architecture.clean.presentation.presenter.TimerServicePresenter
import javax.inject.Inject

/**
 * Timer service.
 */

class TimerService : IntentService("TimerService"), TimerServiceView {
    @Inject
    lateinit var timerServicePresenter: TimerServicePresenter

    override fun onCreate() {
        super.onCreate()
        DaggerTimerServiceComponent.create().inject(this)
        timerServicePresenter.initialize(this)
    }


    override fun onHandleIntent(intent: Intent?) {
        timerServicePresenter.onHandleIntent()
    }

    override fun setServiceIsStarted() {
        isStarted = true
    }

    override fun isServiceStarted(): Boolean = isStarted

    override fun sendBroadcast(seconds: Int) {
        LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(Intent(SECONDS_COUNT_ACTION).putExtra(EXTRA_SECONDS_COUNT, seconds))
    }

    companion object {
        const val SECONDS_COUNT_ACTION = "com.architecture.clean.presentation.service.TimerService.SECONDS_COUNT_ACTION"
        const val EXTRA_SECONDS_COUNT = "com.architecture.clean.presentation.service.TimerService.EXTRA_SECONDS_COUNT"

        // it's better to bind to the service to get the status
        var isStarted = false
    }

    override fun onDestroy() {
        super.onDestroy()
        isStarted = false
    }
}