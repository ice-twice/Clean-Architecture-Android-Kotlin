package com.architecture.clean.presentation.view.topiclist

import android.os.Bundle
import android.view.View
import com.architecture.clean.R
import com.architecture.clean.presentation.di.ModuleProvider
import com.architecture.clean.presentation.di.component.DaggerTopicsComponent
import com.architecture.clean.presentation.navigation.Navigator
import com.architecture.clean.presentation.view.base.fragment.BaseFragment
import com.architecture.clean.presentation.view.base.interfaces.TopicsView
import kotlinx.android.synthetic.main.fragment_topic_list.*
import javax.inject.Inject

/**
 * The main topics fragment.
 */
class TopicListFragment : BaseFragment(), TopicsView {
    @Inject
    lateinit var topicsPresenter: TopicsPresenter
    @Inject
    lateinit var navigator: Navigator

    override fun layoutId(): Int = R.layout.fragment_topic_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerTopicsComponent.builder()
                .navigationModule(ModuleProvider.navigatorModule)
                .build()
                .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        topicsPresenter.initialize(this)

        clean_architecture.setOnClickListener {
            topicsPresenter.onClickCleanArchitecture()
        }

        clean_architecture_advantages.setOnClickListener {
            topicsPresenter.onClickCleanArchitectureAdvantages()
        }

        news_list.setOnClickListener {
            topicsPresenter.onClickNewsList()
        }
    }

    override fun showCleanArchitectureView() {
        navigator.showCleanArchitectureView(context)
    }

    override fun showCleanArchitectureAdvantagesView() {
        navigator.showCleanArchitectureAdvantagesView(context)
    }

    override fun showNewsListView() {
        navigator.showNewsListView(context)
    }
}