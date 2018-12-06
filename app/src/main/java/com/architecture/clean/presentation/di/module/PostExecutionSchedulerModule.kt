package com.architecture.clean.presentation.di.module

import com.architecture.clean.domain.scheduler.PostExecutionScheduler
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Singleton

/**
 * The post execution scheduler.
 */
@Module
class PostExecutionSchedulerModule : AbstractModuleReferenceSoft<PostExecutionScheduler>() {

    @Provides
    @Singleton
    internal fun providePostExecutionScheduler(): PostExecutionScheduler {
        return getInstance {
            object : PostExecutionScheduler {
                override val scheduler: Scheduler
                    get() = AndroidSchedulers.mainThread()
            }
        }
    }
}