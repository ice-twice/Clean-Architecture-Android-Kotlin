package com.architecture.clean.presentation.presenter

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.architecture.clean.presentation.interfaces.TimerView
import javax.inject.Inject

class TimerPresenter @Inject constructor() : BasePresenter<TimerView>() {
    override var viewLifecycleObserver: LifecycleObserver? = ViewLifecycleObserver()
    override var viewLayoutLifecycleObserver: LifecycleObserver? = ViewLayoutLifecycleObserver()

    /**
     * This class is used to handle the view lifecycle.
     */
    inner class ViewLifecycleObserver : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onCreate() {
            view.registerTimeReceiver()
            view.startTimer()
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy() {
            // todo unregister receiver
        }
    }

    /**
     * This class is used to handle the layout lifecycle.
     *
     * This is useful to restore the view state after changing the screen orientation.
     */
    inner class ViewLayoutLifecycleObserver : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun create() {

        }
    }
}