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
 * The module is uses to provide schedulers.
 */
@Module
class SchedulerModule : AbstractModuleSoftReference<BackgroundScheduler>() {
    private var postExecutionScheduler: SoftReference<PostExecutionScheduler>? = null

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

    @Provides
    @Singleton
    internal fun providePostExecutionScheduler(): PostExecutionScheduler {
        val pair = getOrCreateInstance(postExecutionScheduler, {
            object : PostExecutionScheduler {
                override val scheduler: Scheduler
                    get() = AndroidSchedulers.mainThread()
            }
        }, { instance -> SoftReference(instance) })
        postExecutionScheduler = pair.second
        return pair.first
    }
}