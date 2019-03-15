package com.architecture.clean.presentation.view.base.interfaces

import com.architecture.clean.domain.News

/**
 * The news list interface.
 */
interface NewsListView {
    /**
     * Show a list of news.
     */
    fun showNews(newsList: List<News>)

    /**
     * Show news.
     */
    fun showNewsContent(title: String)
}