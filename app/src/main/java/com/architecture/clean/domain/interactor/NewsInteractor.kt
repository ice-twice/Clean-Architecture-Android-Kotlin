package com.architecture.clean.domain.interactor

import com.architecture.clean.domain.News
import com.architecture.clean.domain.interactor.abstractinteractor.SingleInteractor
import com.architecture.clean.domain.interactor.abstractinteractor.adapter.stream.StreamAdapterSingle
import com.architecture.clean.domain.repository.NewsRepository
import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.domain.scheduler.PostExecutionScheduler
import javax.inject.Inject

/**
 * The news interactor.
 */
class NewsInteractor @Inject constructor(override val backgroundScheduler: BackgroundScheduler, override val postExecutionScheduler: PostExecutionScheduler, private val newsRepository: NewsRepository) : SingleInteractor<Any, List<News>>(backgroundScheduler, postExecutionScheduler) {

    override fun create(param: Any): StreamAdapterSingle<List<News>> {
        return StreamAdapterSingle(newsRepository.getNews())
    }
}