package com.architecture.clean.presentation.di.module

import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.domain.scheduler.PostExecutionScheduler
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.ref.SoftReference
import javax.inject.Singleton

/**
 * The background schedulers.
 */
@Module
class BackgroundSchedulerModule : AbstractModuleSoftReference<BackgroundScheduler>() {

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