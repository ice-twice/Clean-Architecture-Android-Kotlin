package com.architecture.clean.presentation.interfaces

/**
 * The timer view interface.
 */
interface TimerView {

    /**
     * Start a timer.
     */
    fun startTimer()

    /**
     * Register a time receiver.
     */
    fun registerTimeReceiver()

    /**
     * Show time.
     */
    fun showTime(seconds: Int?)
}