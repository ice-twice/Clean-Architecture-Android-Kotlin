package com.architecture.clean.presentation.view.internetstatus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import com.architecture.clean.R
import com.architecture.clean.presentation.view.base.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_internet_status.*

/**
 * A screen that contains an example of using coordinator layout and shows status of the internet connection.
 */
// todo add a presenter
class InternetStatusFragment : BaseFragment() {
    override fun layoutId(): Int = R.layout.fragment_internet_status
    private var broadcastReceiver: BroadcastReceiver? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                val networkInfo = intent?.extras?.get(ConnectivityManager.EXTRA_NETWORK_INFO) as NetworkInfo
                internet_connection_switch.isChecked = networkInfo.isConnected
            }
        }
        context?.registerReceiver(broadcastReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    override fun onDestroy() {
        super.onDestroy()
        context?.unregisterReceiver(broadcastReceiver)
    }
}