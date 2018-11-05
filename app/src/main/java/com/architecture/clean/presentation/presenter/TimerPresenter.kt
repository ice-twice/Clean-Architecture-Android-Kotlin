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
            if (view.isServiceRunning()) {
                view.disableStartServiceButton()
                view.enableStopServiceButton()
                view.setLoadingText()
            } else {
                view.enableStartServiceButton()
                view.disableStopServiceButton()
                view.setServiceStoppedText()
            }
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
    }

    fun onUpdateTime(remainSeconds: Int?) {
        if (remainSeconds != null) {
            view.showTime(remainSeconds)
        }
    }
}