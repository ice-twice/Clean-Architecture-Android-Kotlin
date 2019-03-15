package com.architecture.clean.presentation.view.newslist

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.lifecycle.OnLifecycleEvent
import com.architecture.clean.domain.News
import com.architecture.clean.domain.interactor.NewsInteractor
import com.architecture.clean.domain.interactor.abstractinteractor.adapter.observer.ObserverAdapter
import com.architecture.clean.presentation.component.StoppableLiveData
import com.architecture.clean.presentation.view.base.interfaces.NewsListView
import com.architecture.clean.presentation.view.base.presenter.BasePresenterViewAndLayoutLifecycle
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

/**
 * The news list presenter.
 */
class NewsListPresenter @Inject constructor(private val newsInteractor: NewsInteractor) : BasePresenterViewAndLayoutLifecycle<NewsListView>() {
    override var viewLayoutLifecycleObserver: LifecycleObserver = ViewLayoutLifecycleObserver()
    override var viewLifecycleObserver: LifecycleObserver = ViewLifecycleObserver()

    private val newsList by lazy(mode = LazyThreadSafetyMode.NONE) {
        StoppableLiveData<List<News>>()
    }

    protected inner class ViewLifecycleObserver : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onCreate() {
            newsInteractor.execute(Unit, ObserverAdapter(object : DisposableSingleObserver<List<News>>() {
                override fun onSuccess(t: List<News>) {
                    newsList.value(t)
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

    protected inner class ViewLayoutLifecycleObserver : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onCreate() {
            newsList.observe(viewLayoutLifecycleOwner, Observer {
                view.showNews(it)
            })
        }
    }

    fun onClickNews(news: News) {
        view.showNewsContent(news.title)
    }
}