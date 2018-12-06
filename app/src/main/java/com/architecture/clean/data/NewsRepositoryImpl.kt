package com.architecture.clean.data

import com.architecture.clean.domain.News
import com.architecture.clean.domain.repository.NewsRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Implementation of the news repository.
 */
class NewsRepositoryImpl @Inject constructor() : NewsRepository {

    override fun getNews(): Single<List<News>> {
        return Single.create { emitter ->
            try {
                Thread.sleep(2000)
            } catch (e: InterruptedException) {
                // empty
            }
            emitter.onSuccess(listOf(News("title", "body")))
        }
    }
}