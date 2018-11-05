package com.architecture.clean.presentation.di.component

import com.architecture.clean.presentation.fragment.TimerFragment
import dagger.Component
import javax.inject.Singleton

/**
 * The timer component.
 */
@Singleton
@Component
interface TimerComponent {
    fun inject(fragment: TimerFragment)
}