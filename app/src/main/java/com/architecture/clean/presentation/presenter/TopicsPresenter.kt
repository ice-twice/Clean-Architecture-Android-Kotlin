package com.architecture.clean.presentation.presenter

import com.architecture.clean.presentation.interfaces.TopicsView
import com.architecture.clean.presentation.presenter.base.BasePresenter
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
}