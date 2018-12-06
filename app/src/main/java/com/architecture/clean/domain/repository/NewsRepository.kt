package com.architecture.clean.domain.repository

import com.architecture.clean.domain.News
import io.reactivex.Single

/**
 * The news repository.
 */
interface NewsRepository {

    /**
     * Get a list of news.
     */
    fun getNews(): Single<List<News>>
}