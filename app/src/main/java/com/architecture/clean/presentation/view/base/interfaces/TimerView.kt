package com.architecture.clean.presentation.view.base.interfaces

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

    /**
     * Set service stopped text.
     */
    fun setServiceStoppedText()

    /**
     * Set loading text.
     */
    fun setLoadingText()

    /**
     * Bind to the service.
     */
    fun bindService()

    /**
     * Unbind the service.
     */
    fun unbindService()
}