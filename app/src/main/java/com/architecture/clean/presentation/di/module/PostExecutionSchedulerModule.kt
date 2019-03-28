package com.architecture.clean.presentation.di.module

import com.architecture.clean.domain.scheduler.PostExecutionScheduler
import com.architecture.clean.presentation.di.module.base.reference.BaseModuleSoftReference
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import java.lang.ref.Reference
import javax.inject.Singleton

/**
 * The post execution scheduler.
 */
@Module
class PostExecutionSchedulerModule : BaseModuleSoftReference<PostExecutionScheduler>() {
    object ReferenceInstance {
        var reference: Reference<PostExecutionScheduler>? = null
    }

    @Provides
    @Singleton
    internal fun providePostExecutionScheduler(): PostExecutionScheduler {
        return getInstance(ReferenceInstance::reference) {
            object : PostExecutionScheduler {
                override val scheduler: Scheduler
                    get() = AndroidSchedulers.mainThread()
            }
        }
    }
}