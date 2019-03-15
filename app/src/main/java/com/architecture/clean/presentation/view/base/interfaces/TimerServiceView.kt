package com.architecture.clean.presentation.view.base.interfaces

/**
 * The timer service view interface.
 */
interface TimerServiceView {
    var isStarted: Boolean

    /**
     * Send a broadcast.
     */
    fun sendBroadcast(seconds: Int)
}