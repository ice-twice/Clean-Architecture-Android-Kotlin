package com.architecture.clean.presentation.di.module

import com.architecture.clean.domain.scheduler.BackgroundScheduler
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import java.util.*

class BackgroundSchedulerModuleTest {
    private lateinit var backgroundSchedulerModule: BackgroundSchedulerModule
    @Before
    internal fun setUp() {
        backgroundSchedulerModule = BackgroundSchedulerModule()
    }


    @Test
    fun testProvideBackgroundScheduler() {
        var backgroundScheduler1: BackgroundScheduler? = backgroundSchedulerModule.provideBackgroundScheduler()
        var backgroundScheduler2: BackgroundScheduler? = backgroundSchedulerModule.provideBackgroundScheduler()
        assertEquals(backgroundScheduler1, backgroundScheduler2)
        val backgroundScheduler1ToString = backgroundScheduler1.toString()
        @Suppress("UNUSED_VALUE")
        backgroundScheduler1 = null
        @Suppress("UNUSED_VALUE")
        backgroundScheduler2 = null

        try {
            val list = LinkedList<LongArray>()
            while (true) {
                list.add(LongArray(65536))
            }
        } catch (e: OutOfMemoryError) {
        }

        val backgroundScheduler3 = backgroundSchedulerModule.provideBackgroundScheduler()
        val backgroundScheduler3ToString = backgroundScheduler3.toString()
        assertNotEquals(backgroundScheduler1ToString, backgroundScheduler3ToString)
    }
}