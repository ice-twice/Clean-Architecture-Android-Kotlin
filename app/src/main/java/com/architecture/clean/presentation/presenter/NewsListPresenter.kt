package com.architecture.clean.presentation.presenter

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.architecture.clean.domain.News
import com.architecture.clean.domain.interactor.NewsInteractor
import com.architecture.clean.domain.interactor.abstractinteractor.adapter.observer.ObserverAdapter
import com.architecture.clean.presentation.interfaces.NewsListView
import com.architecture.clean.presentation.presenter.base.BasePresenterViewAndLayoutLifecycle
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

/**
 * The news list presenter.
 */
class NewsListPresenter @Inject constructor(private val newsInteractor: NewsInteractor) : BasePresenterViewAndLayoutLifecycle<NewsListView>() {
    override var viewLayoutLifecycleObserver: LifecycleObserver = ViewLayoutLifecycleObserver()
    override var viewLifecycleObserver: LifecycleObserver = ViewLifecycleObserver()

    protected inner class ViewLifecycleObserver : LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onCreate() {
            newsInteractor.execute(Unit, ObserverAdapter(object : DisposableSingleObserver<List<News>>() {
                override fun onSuccess(t: List<News>) {

                }

                override fun onError(e: Throwable) {
                    // empty
                }
            }))
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy() {
            newsInteractor.dispose()
        }
    }

    protected inner class ViewLayoutLifecycleObserver : LifecycleObserver
}