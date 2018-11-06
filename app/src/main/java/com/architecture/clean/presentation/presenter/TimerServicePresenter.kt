package com.architecture.clean.presentation.presenter

import com.architecture.clean.presentation.interfaces.TimerServiceView
import com.architecture.clean.presentation.presenter.base.BasePresenter
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * The timer service presenter.
 */
class TimerServicePresenter @Inject constructor() : BasePresenter<TimerServiceView>() {
    private val seconds = 20

    fun onHandleIntent() {
        view.setServiceIsStarted()
        var remainSeconds = seconds
        while (remainSeconds > 0) {
            TimeUnit.SECONDS.sleep(1L)
            remainSeconds--
            if (!view.isServiceStarted()) break
            view.sendBroadcast(remainSeconds)
        }
    }
}