package com.architecture.clean.presentation.di.component

import com.architecture.clean.presentation.service.TimerService
import dagger.Component
import javax.inject.Singleton

/**
 * The timer service component.
 */
@Singleton
@Component
interface TimerServiceComponent {
    fun inject(timerService: TimerService)
}