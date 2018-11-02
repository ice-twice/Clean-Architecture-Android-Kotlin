package com.architecture.clean.presentation.presenter

import com.architecture.clean.presentation.interfaces.TopicsView
import javax.inject.Inject

class TopicsPresenter @Inject constructor() : BasePresenter<TopicsView>() {
    fun onClickCleanArchitecture() {
        view.showCleanArchitectureView()
    }
}