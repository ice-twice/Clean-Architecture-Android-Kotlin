package com.architecture.clean.presentation.service

import android.app.IntentService
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import java.util.concurrent.TimeUnit

/**
 * Timer service.
 */

// todo add presenter
class TimerService : IntentService("TimerService") {
    private val seconds = 20
    private var isStarted = false
    private var isCancelled = false

    override fun onHandleIntent(intent: Intent?) {
        // start only once
        if (isStarted) return
        isStarted = true
        var remainSeconds = seconds
        while (remainSeconds > 0) {
            if (isCancelled) break
            TimeUnit.SECONDS.sleep(1L)
            remainSeconds--
            LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(Intent(SECONDS_COUNT_ACTION).putExtra(EXTRA_SECONDS_COUNT, remainSeconds))
        }
    }

    companion object {
        const val SECONDS_COUNT_ACTION = "com.architecture.clean.presentation.service.TimerService.SECONDS_COUNT_ACTION"
        const val EXTRA_SECONDS_COUNT = "com.architecture.clean.presentation.service.TimerService.EXTRA_SECONDS_COUNT"
    }

    override fun onDestroy() {
        super.onDestroy()
        isCancelled = true
    }
}