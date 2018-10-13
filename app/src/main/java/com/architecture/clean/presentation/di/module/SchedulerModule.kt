package com.architecture.clean.presentation.di.module

import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.domain.scheduler.PostExecutionScheduler
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

/**
 * The module is uses to provide schedulers.
 */
@Module
class SchedulerModule {
    private val backgroundScheduler by lazy(mode = LazyThreadSafetyMode.NONE) {
        object : BackgroundScheduler {
            override val scheduler: Scheduler
                get() = Schedulers.computation()
        }
    }

    private val postExecutionScheduler by lazy(mode = LazyThreadSafetyMode.NONE) {
        object : PostExecutionScheduler {
            override val scheduler: Scheduler
                get() = AndroidSchedulers.mainThread()
        }
    }

    @Provides
    @Singleton
    internal fun provideBackgroundScheduler(): BackgroundScheduler {
        return backgroundScheduler
    }

    @Provides
    @Singleton
    internal fun providePostExecutionScheduler(): PostExecutionScheduler {
        return postExecutionScheduler
    }
}