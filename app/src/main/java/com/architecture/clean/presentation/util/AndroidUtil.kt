package com.architecture.clean.presentation.util

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.view.View
import android.view.inputmethod.InputMethodManager


/**
 * Utils.
 */
class AndroidUtil {
    /**
     * Hide keyboard.
     */
    fun hideKeyboard(context: Context?, view: View?) {
        val imm = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }

    /**
     * Check whether internet connection is available.
     */
    fun isInternetConnection(context: Context): Boolean {
        val networkInfo = (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
        return networkInfo?.isConnected ?: false
    }
}