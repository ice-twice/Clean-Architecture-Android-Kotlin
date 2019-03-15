package com.architecture.clean.presentation.view.timer

import com.architecture.clean.presentation.view.base.interfaces.TimerServiceView
import com.architecture.clean.presentation.view.base.presenter.BasePresenter
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * The timer service presenter.
 */
class TimerServicePresenter @Inject constructor() : BasePresenter<TimerServiceView>() {
    private val seconds = 20

    fun onHandleIntent() {
        view.isStarted = true
        var remainSeconds = seconds
        while (remainSeconds > 0) {
            TimeUnit.SECONDS.sleep(1L)
            remainSeconds--
            if (!view.isStarted) break
            view.sendBroadcast(remainSeconds)
        }
    }
}