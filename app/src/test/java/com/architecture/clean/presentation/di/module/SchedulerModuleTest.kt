package com.architecture.clean.presentation.di.module

import com.architecture.clean.domain.scheduler.BackgroundScheduler
import com.architecture.clean.domain.scheduler.PostExecutionScheduler
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

class SchedulerModuleTest {
    private lateinit var schedulerModule: SchedulerModule
    @Before
    internal fun setUp() {
        schedulerModule = SchedulerModule()
    }

    @Test
    internal fun testProvideBackgroundScheduler() {
        var backgroundScheduler1: BackgroundScheduler? = schedulerModule.provideBackgroundScheduler()
        var backgroundScheduler2: BackgroundScheduler? = schedulerModule.provideBackgroundScheduler()
        assertEquals(backgroundScheduler1, backgroundScheduler2)
        val backgroundScheduler1ToString = backgroundScheduler1.toString()
        backgroundScheduler1 = null
        backgroundScheduler2 = null

        // force the JVM to clear all SoftReferences
        try {
            val ignored = arrayOfNulls<Any>(Runtime.getRuntime().maxMemory().toInt())
        } catch (e: OutOfMemoryError) {
            // Ignore
        }

        val backgroundScheduler3 = schedulerModule.provideBackgroundScheduler()
        val backgroundScheduler3ToString = backgroundScheduler3.toString()
        assertNotEquals(backgroundScheduler1ToString, backgroundScheduler3ToString)
    }

    @Test
    internal fun testProvidePostExecutionScheduler() {
        var postExecutionScheduler1: PostExecutionScheduler? = schedulerModule.providePostExecutionScheduler()
        var postExecutionScheduler2: PostExecutionScheduler? = schedulerModule.providePostExecutionScheduler()
        assertEquals(postExecutionScheduler1, postExecutionScheduler2)
        val postExecutionScheduler1ToString = postExecutionScheduler1.toString()
        postExecutionScheduler1 = null
        postExecutionScheduler2 = null

        // force the JVM to clear all SoftReferences
        try {
            val ignored = arrayOfNulls<Any>(Runtime.getRuntime().maxMemory().toInt())
        } catch (e: OutOfMemoryError) {
            // Ignore
        }

        val postExecutionScheduler3 = schedulerModule.providePostExecutionScheduler()
        val postExecutionScheduler3ToString = postExecutionScheduler3.toString()
        assertNotEquals(postExecutionScheduler1ToString, postExecutionScheduler3ToString)
    }

    @Test
    fun testIfInstancesAreDifferent() {
        assertNotEquals(SchedulerModule().provideBackgroundScheduler(), SchedulerModule().provideBackgroundScheduler())
        assertNotEquals(SchedulerModule().providePostExecutionScheduler(), SchedulerModule().providePostExecutionScheduler())
    }
}