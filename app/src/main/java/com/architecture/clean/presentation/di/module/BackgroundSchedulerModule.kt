package com.architecture.clean.presentation.di.module

import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.presentation.di.module.base.reference.BaseModuleSoftReference
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import java.lang.ref.Reference
import javax.inject.Singleton

/**
 * The background schedulers.
 */
@Module
class BackgroundSchedulerModule : BaseModuleSoftReference<BackgroundScheduler>() {
    object ReferenceInstance {
        var reference: Reference<BackgroundScheduler>? = null
    }

    @Provides
    @Singleton
    fun provideBackgroundScheduler(): BackgroundScheduler {
        return getInstance(ReferenceInstance::reference) {
            object : BackgroundScheduler {
                override val scheduler: Scheduler
                    get() = Schedulers.computation()
            }
        }
    }
}