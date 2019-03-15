package com.architecture.clean.presentation.di.module

import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.presentation.di.module.base.AbstractModuleReferenceSoft
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

/**
 * The background schedulers.
 */
@Module
class BackgroundSchedulerModule : AbstractModuleReferenceSoft<BackgroundScheduler>() {

    @Provides
    @Singleton
    internal fun provideBackgroundScheduler(): BackgroundScheduler {
        return getInstance {
            object : BackgroundScheduler {
                override val scheduler: Scheduler
                    get() = Schedulers.computation()
            }
        }
    }
}