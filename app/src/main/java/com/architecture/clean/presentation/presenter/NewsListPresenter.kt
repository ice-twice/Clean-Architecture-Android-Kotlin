package com.architecture.clean.presentation.presenter

import androidx.lifecycle.LifecycleObserver
import com.architecture.clean.domain.interactor.NewsInteractor
import com.architecture.clean.presentation.interfaces.NewsListView
import com.architecture.clean.presentation.presenter.base.BasePresenterViewAndLayoutLifecycle
import javax.inject.Inject

/**
 * The news list presenter.
 */
class NewsListPresenter @Inject constructor(private val newsInteractor: NewsInteractor) : BasePresenterViewAndLayoutLifecycle<NewsListView>() {
    override var viewLayoutLifecycleObserver: LifecycleObserver = ViewLayoutLifecycleObserver()
    override var viewLifecycleObserver: LifecycleObserver = ViewLifecycleObserver()

    protected inner class ViewLifecycleObserver : LifecycleObserver {
    }

    protected inner class ViewLayoutLifecycleObserver : LifecycleObserver {
    }
}