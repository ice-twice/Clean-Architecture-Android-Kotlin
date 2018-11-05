package com.architecture.clean.presentation.interfaces

/**
 * The timer view interface.
 */
interface TimerView {

    /**
     * Start a timer.
     */
    fun startServiceTimer()

    /**
     * Register a time receiver.
     */
    fun registerTimeReceiver()

    /**
     * Show time.
     */
    fun showTime(seconds: Int?)

    /**
     * Unregister a time receiver.
     */
    fun unregisterTimeReceiver()

    /**
     * Stop the service timer.
     */
    fun stopServiceTimer()

    /**
     * Is the service running.
     */
    fun isServiceRunning(): Boolean

    /**
     * Disable the start service button.
     */
    fun disableStartServiceButton()

    /**
     * Enable the stop service button.
     */
    fun enableStopServiceButton()

    /**
     * Enable the start service button.
     */
    fun enableStartServiceButton()

    /**
     * Disable the stop service button.
     */
    fun disableStopServiceButton()
}