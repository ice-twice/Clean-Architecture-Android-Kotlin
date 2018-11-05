package com.architecture.clean.presentation.presenter

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.architecture.clean.presentation.interfaces.TimerView
import com.architecture.clean.presentation.presenter.base.BasePresenterViewAndLayoutLifecycle
import javax.inject.Inject

class TimerPresenter @Inject constructor() : BasePresenterViewAndLayoutLifecycle<TimerView>() {
    override var viewLifecycleObserver: LifecycleObserver = ViewLifecycleObserver()
    override var viewLayoutLifecycleObserver: LifecycleObserver = ViewLayoutLifecycleObserver()

    protected inner class ViewLifecycleObserver : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onCreate() {
            val isServiceRunning = view.isServiceRunning()
            if (isServiceRunning) {
                view.disableStartServiceButton()
                view.enableStopServiceButton()
            } else {
                view.enableStartServiceButton()
                view.disableStopServiceButton()
            }
            view.registerTimeReceiver()
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy() {
            view.unregisterTimeReceiver()
        }
    }

    protected inner class ViewLayoutLifecycleObserver : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun create() {

        }
    }

    fun onClickStartService() {
        view.startServiceTimer()
        view.disableStartServiceButton()
        view.enableStopServiceButton()
    }

    fun onClickStopService() {
        view.stopServiceTimer()
        view.enableStartServiceButton()
        view.disableStopServiceButton()
    }

    fun onUpdateTime(remainSeconds: Int?) {
        if (remainSeconds != null) {
            view.showTime(remainSeconds)
        }
    }
}