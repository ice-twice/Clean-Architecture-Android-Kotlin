package com.architecture.clean.presentation.view.util

import android.app.Activity
import android.content.Context
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
}