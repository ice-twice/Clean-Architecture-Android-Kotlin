package com.architecture.clean.presentation.view.topiclist

import com.architecture.clean.presentation.view.base.interfaces.TopicsView
import com.architecture.clean.presentation.view.base.presenter.BasePresenter
import javax.inject.Inject

/**
 * The topics presenter.
 */
class TopicsPresenter @Inject constructor() : BasePresenter<TopicsView>() {
    /**
     * Handle a click event of the clean architecture button.
     */
    fun onClickCleanArchitecture() {
        view.showCleanArchitectureView()
    }

    /**
     * Handle a click event of the clean architecture advantages button.
     */
    fun onClickCleanArchitectureAdvantages() {
        view.showCleanArchitectureAdvantagesView()
    }

    /**
     * Show the news list view.
     */
    fun onClickNewsList() {
        view.showNewsListView()
    }
}