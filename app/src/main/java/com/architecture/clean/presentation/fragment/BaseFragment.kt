package com.architecture.clean.presentation.fragment

import androidx.fragment.app.Fragment
import com.architecture.clean.presentation.AndroidApplication
import com.architecture.clean.presentation.di.ModuleProvider

/**
 * Base fragment.
 */
abstract class BaseFragment : Fragment() {
    fun getModuleProvider(): ModuleProvider {
        return (activity?.application as AndroidApplication).moduleProvider
    }
}