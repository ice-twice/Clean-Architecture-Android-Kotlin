package com.architecture.clean.domain.scheduler

import io.reactivex.Scheduler

/**
 * Base interface for schedulers.
 */
interface GetScheduler {
    val scheduler: Scheduler
}