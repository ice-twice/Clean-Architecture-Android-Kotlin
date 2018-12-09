package com.architecture.clean.presentation.interfaces

import com.architecture.clean.domain.News

/**
 * The news list interface.
 */
interface NewsListView {
    /**
     * Show a list of news.
     */
    fun showNews(newsList: List<News>)
}