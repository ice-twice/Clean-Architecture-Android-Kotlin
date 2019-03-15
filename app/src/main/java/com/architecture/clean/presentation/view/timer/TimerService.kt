package com.architecture.clean.presentation.view.timer

import android.app.IntentService
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.architecture.clean.presentation.di.component.DaggerTimerServiceComponent
import com.architecture.clean.presentation.view.base.interfaces.TimerServiceView
import javax.inject.Inject

/**
 * Timer service.
 */

class TimerService : IntentService("TimerService"), TimerServiceView {
    @Inject
    lateinit var timerServicePresenter: TimerServicePresenter
    override var isStarted = false

    private val timerServiceBinder by lazy(mode = LazyThreadSafetyMode.NONE) {
        TimerServiceBinder()
    }

    override fun onCreate() {
        super.onCreate()
        DaggerTimerServiceComponent.create().inject(this)
        timerServicePresenter.initialize(this)
    }

    override fun onHandleIntent(intent: Intent?) {
        timerServicePresenter.onHandleIntent()
    }

    override fun sendBroadcast(seconds: Int) {
        LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(Intent(SECONDS_COUNT_ACTION).putExtra(EXTRA_SECONDS_COUNT, seconds))
    }

    companion object {
        const val SECONDS_COUNT_ACTION = "com.architecture.clean.presentation.view.timer.TimerService.SECONDS_COUNT_ACTION"
        const val EXTRA_SECONDS_COUNT = "com.architecture.clean.presentation.view.timer.TimerService.EXTRA_SECONDS_COUNT"
    }

    override fun onDestroy() {
        super.onDestroy()
        isStarted = false
    }

    override fun onBind(intent: Intent?): IBinder? {
        return timerServiceBinder
    }

    inner class TimerServiceBinder : Binder() {
        fun getTimerService(): TimerService {
            return this@TimerService
        }
    }
}