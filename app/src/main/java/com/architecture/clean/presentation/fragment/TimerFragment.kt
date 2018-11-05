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
import kotlinx.android.synthetic.main.fragment_timer.*
import javax.inject.Inject

/**
 * Timer fragment.
 */
class TimerFragment : BaseFragment(), TimerView {
    override fun layoutId(): Int = R.layout.fragment_timer

    @Inject
    lateinit var timerPresenter: TimerPresenter
    private lateinit var secondsCountReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerTimerComponent.create()
                .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        timerPresenter.initialize(this, this, viewLifecycleOwner)

        start_timer_service.setOnClickListener {
            timerPresenter.onClickStartService()
        }

        stop_timer_service.setOnClickListener {
            timerPresenter.onClickStopService()
        }
    }

    override fun startServiceTimer() {
        context?.startService(Intent(context, TimerService::class.java))
    }

    override fun registerTimeReceiver() {
        secondsCountReceiver = SecondsCountReceiver()
        LocalBroadcastManager.getInstance(context!!)
                .registerReceiver(secondsCountReceiver, IntentFilter(TimerService.SECONDS_COUNT_ACTION))
    }

    private inner class SecondsCountReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            timerPresenter.onUpdateTime(intent?.getIntExtra(TimerService.EXTRA_SECONDS_COUNT, 0))
        }
    }

    override fun unregisterTimeReceiver() {
        LocalBroadcastManager.getInstance(context!!).unregisterReceiver(secondsCountReceiver)
    }

    override fun showTime(seconds: Int?) {
        seconds_count.text = seconds.toString()
    }

    override fun stopServiceTimer() {
        context?.stopService(Intent(context, TimerService::class.java))
    }
}