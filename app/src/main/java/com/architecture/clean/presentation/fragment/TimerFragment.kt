package com.architecture.clean.presentation.fragment

import android.content.*
import android.os.Bundle
import android.os.IBinder
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

    private lateinit var timerServiceConnection: ServiceConnection

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

    override fun disableStartServiceButton() {
        start_timer_service.isEnabled = false
    }

    override fun enableStopServiceButton() {
        stop_timer_service.isEnabled = true
    }

    override fun enableStartServiceButton() {
        start_timer_service.isEnabled = true
    }

    override fun disableStopServiceButton() {
        stop_timer_service.isEnabled = false
    }

    override fun setServiceStoppedText() {
        seconds_count.text = getString(R.string.service_stopped)
    }

    override fun setLoadingText() {
        seconds_count.text = getString(R.string.loading)
    }

    override fun registerTimeReceiver() {
        secondsCountReceiver = SecondsCountReceiver()
        LocalBroadcastManager.getInstance(context!!)
                .registerReceiver(secondsCountReceiver, IntentFilter(TimerService.SECONDS_COUNT_ACTION))
    }

    /**
     * Bind to the service to get the service instance to know if the service was started/
     */
    override fun bindService() {
        timerServiceConnection = object : ServiceConnection {

            override fun onServiceConnected(className: ComponentName, timerServiceBinder: IBinder) {
                timerPresenter.onServiceConnected((timerServiceBinder as TimerService.TimerServiceBinder).getTimerService())
            }

            override fun onServiceDisconnected(arg0: ComponentName) {
            }
        }
        context?.bindService(Intent(context, TimerService::class.java), timerServiceConnection, Context.BIND_AUTO_CREATE)
    }

    override fun unbindService() {
        context?.unbindService(timerServiceConnection)
    }

    override fun startServiceTimer() {
        context?.startService(Intent(context, TimerService::class.java))
    }

    override fun stopServiceTimer() {
        context?.stopService(Intent(context, TimerService::class.java))
    }

    private inner class SecondsCountReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            timerPresenter.onUpdateTime(intent?.getIntExtra(TimerService.EXTRA_SECONDS_COUNT, 0))
        }
    }

    override fun showTime(seconds: Int?) {
        seconds_count.text = seconds.toString()
    }

    override fun unregisterTimeReceiver() {
        LocalBroadcastManager.getInstance(context!!).unregisterReceiver(secondsCountReceiver)
    }
}