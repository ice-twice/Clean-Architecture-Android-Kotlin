package com.architecture.clean.presentation.interfaces

/**
 * The timer service view interface.
 */
interface TimerServiceView {

    /**
     * Set that the service is started.
     */
    fun setServiceIsStarted()

    /**
     * Is the service started.
     */
    fun isServiceStarted(): Boolean

    /**
     * Send a broadcast.
     */
    fun sendBroadcast(seconds: Int)
}