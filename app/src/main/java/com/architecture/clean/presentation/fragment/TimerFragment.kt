package com.architecture.clean.presentation.fragment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.architecture.clean.R
import com.architecture.clean.presentation.di.component.DaggerTimerComponent
import com.architecture.clean.presentation.interfaces.TimerView
import com.architecture.clean.presentation.presenter.TimerPresenter
import com.architecture.clean.presentation.service.TimerService
import javax.inject.Inject

/**
 * Timer fragment.
 */
class TimerFragment : BaseFragment(), TimerView {
    override fun layoutId(): Int = R.layout.fragment_timer

    @Inject
    lateinit var timerPresenter: TimerPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerTimerComponent.create()
                .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        timerPresenter.initialize(this, this, viewLifecycleOwner)
    }

    override fun startTimer() {
        val intent = Intent(context, TimerService::class.java)
        context?.startService(intent)
    }

    override fun registerTimeReceiver() = LocalBroadcastManager.getInstance(context!!)
            .registerReceiver(object : BroadcastReceiver() {
                override fun onReceive(context: Context?, intent: Intent?) {
                    timerPresenter.onUpdateTime(intent?.getIntExtra(TimerService.EXTRA_SECONDS_COUNT, 0))
                }
            }, IntentFilter(TimerService.SECONDS_COUNT_ACTION))

    override fun showTime(seconds: Int?) {
        println("showTime = $seconds")
    }
}