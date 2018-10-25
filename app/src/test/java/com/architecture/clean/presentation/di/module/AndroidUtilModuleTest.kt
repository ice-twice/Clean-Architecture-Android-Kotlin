package com.architecture.clean.presentation.di.module

import com.architecture.clean.presentation.util.AndroidUtil
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test


internal class AndroidUtilModuleTest {
    private lateinit var androidUtilModule: AndroidUtilModule
    @Before
    internal fun setUp() {
        androidUtilModule = AndroidUtilModule()
    }

    @Test
    internal fun testProvideAndroidUtil() {
        var androidUtil1: AndroidUtil? = androidUtilModule.provideAndroidUtil()
        var androidUtil2: AndroidUtil? = androidUtilModule.provideAndroidUtil()
        assertEquals(androidUtil1, androidUtil2)
        val androidUtil1ToString = androidUtil1.toString()
        androidUtil1 = null
        androidUtil2 = null

        // force the JVM to clear all SoftReferences
        try {
            val ignored = arrayOfNulls<Any>(Runtime.getRuntime().maxMemory().toInt())
        } catch (e: OutOfMemoryError) {
            // Ignore
        }

        val androidUtil3 = androidUtilModule.provideAndroidUtil()
        val androidUtil3ToString = androidUtil3.toString()
        assertNotEquals(androidUtil1ToString, androidUtil3ToString)
    }

    @Test
    fun testIfInstancesAreDifferent() {
        assertNotEquals(AndroidUtilModule().provideAndroidUtil(), AndroidUtilModule().provideAndroidUtil())
    }
}