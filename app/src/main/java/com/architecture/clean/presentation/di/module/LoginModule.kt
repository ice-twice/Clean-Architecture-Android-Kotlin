package com.architecture.clean.presentation.di.module

import com.architecture.clean.domain.interactor.LoginInteractor
import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.domain.scheduler.PostExecutionScheduler
import com.architecture.clean.presentation.view.presenter.LoginPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
class LoginModule() {

    @Provides
    @Singleton
    internal fun provideBackgroundScheduler(): BackgroundScheduler {
        return object : BackgroundScheduler {
            override val scheduler: Scheduler
                get() = Schedulers.computation()
        }
    }

    @Provides
    @Singleton
    internal fun providePostExecutionScheduler(): PostExecutionScheduler {
        return object : PostExecutionScheduler {
            override val scheduler: Scheduler
                get() = AndroidSchedulers.mainThread()
        }
    }
}