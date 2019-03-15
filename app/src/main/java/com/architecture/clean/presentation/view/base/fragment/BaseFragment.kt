package com.architecture.clean.presentation.view.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.architecture.clean.presentation.AndroidApplication
import com.architecture.clean.presentation.di.ModuleProvider

/**
 * Base fragment.
 */
abstract class BaseFragment : Fragment() {
    abstract fun layoutId(): Int

    fun getModuleProvider(): ModuleProvider = (activity?.application as AndroidApplication).moduleProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(layoutId(), container, false)
}