package com.architecture.clean.presentation.view.timer

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.architecture.clean.presentation.view.base.interfaces.TimerServiceView
import com.architecture.clean.presentation.view.base.interfaces.TimerView
import com.architecture.clean.presentation.view.base.presenter.BasePresenterViewAndLayoutLifecycle
import javax.inject.Inject

/**
 * Time presenter.
 */
class TimerPresenter @Inject constructor() : BasePresenterViewAndLayoutLifecycle<TimerView>() {
    override var viewLifecycleObserver: LifecycleObserver = ViewLifecycleObserver()
    override var viewLayoutLifecycleObserver: LifecycleObserver = ViewLayoutLifecycleObserver()
    private var isBoundToService = false

    protected inner class ViewLifecycleObserver : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onCreate() {
            view.registerTimeReceiver()
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy() {
            view.unregisterTimeReceiver()
        }
    }

    protected inner class ViewLayoutLifecycleObserver : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onCreate() {
            view.bindService()
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy() {
            unbindService()
        }
    }

    fun onClickStartService() {
        view.startServiceTimer()
        view.disableStartServiceButton()
        view.enableStopServiceButton()
        view.setLoadingText()
    }

    fun onClickStopService() {
        view.stopServiceTimer()
        view.enableStartServiceButton()
        view.disableStopServiceButton()
        view.setServiceStoppedText()
        unbindService()
    }

    fun onUpdateTime(remainSeconds: Int?) {
        // todo it can be improved with using Live Data.
        if (remainSeconds != null) {
            view.showTime(remainSeconds)
        }
    }

    fun onServiceConnected(timerServiceView: TimerServiceView) {
        // todo it can be improved with using Live Data.
        isBoundToService = true
        if (timerServiceView.isStarted) {
            view.disableStartServiceButton()
            view.enableStopServiceButton()
            view.setLoadingText()
        } else {
            view.enableStartServiceButton()
            view.disableStopServiceButton()
            view.setServiceStoppedText()
        }
    }

    private fun unbindService() {
        if (isBoundToService) {
            view.unbindService()
            isBoundToService = false
        }
    }
}