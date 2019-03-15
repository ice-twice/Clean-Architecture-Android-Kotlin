package com.architecture.clean.presentation.view.newslist

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.architecture.clean.R
import com.architecture.clean.domain.News
import com.architecture.clean.presentation.di.component.DaggerNewsListComponent
import com.architecture.clean.presentation.view.base.fragment.BaseFragment
import com.architecture.clean.presentation.view.base.interfaces.NewsListView
import kotlinx.android.synthetic.main.fragment_news_list.*
import javax.inject.Inject

/**
 * The news list fragment.
 */
class NewsListFragment : BaseFragment(), NewsListView {
    override fun layoutId(): Int = R.layout.fragment_news_list

    @Inject
    lateinit var newsListPresenter: NewsListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerNewsListComponent.builder()
                .backgroundSchedulerModule(getModuleProvider().backgroundSchedulerModule)
                .postExecutionSchedulerModule(getModuleProvider().postExecutionSchedulerModule)
                .newsRepositoryModule(getModuleProvider().newsRepositoryModule)
                .build()
                .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsListPresenter.initialize(this, this, viewLifecycleOwner)
    }

    override fun showNews(newsList: List<News>) {
        progress.visibility = View.GONE
        news_list.visibility = View.VISIBLE
        news_list.adapter = NewsRecyclerViewAdapter(newsList, object : NewsRecyclerViewAdapter.OnClickNewsListener {
            override fun onClickNews(news: News) {
                newsListPresenter.onClickNews(news)
            }
        })
    }

    override fun showNewsContent(title: String) {
        Toast.makeText(context, title, Toast.LENGTH_SHORT).show()
    }
}