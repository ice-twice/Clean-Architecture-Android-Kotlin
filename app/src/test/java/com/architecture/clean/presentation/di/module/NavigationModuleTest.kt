package com.architecture.clean.presentation.di.module

import com.architecture.clean.presentation.navigation.Navigator
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

class NavigationModuleTest {
    private lateinit var navigationModule: NavigationModule
    @Before
    internal fun setUp() {
        navigationModule = NavigationModule()
    }

    @Test
    internal fun testProvideNavigator() {
        var navigator1: Navigator? = navigationModule.provideNavigator()
        var navigator2: Navigator? = navigationModule.provideNavigator()
        assertEquals(navigator1, navigator2)
        val navigator1ToString = navigator1.toString()
        navigator1 = null
        navigator2 = null

        // force the JVM to clear all SoftReferences
        try {
            val ignored = arrayOfNulls<Any>(Runtime.getRuntime().maxMemory().toInt())
        } catch (e: OutOfMemoryError) {
            // Ignore
        }

        val navigator3 = navigationModule.provideNavigator()
        val navigator3ToString = navigator3.toString()
        assertNotEquals(navigator1ToString, navigator3ToString)
    }

    @Test
    fun testIfInstancesAreDifferent() {
        assertNotEquals(NavigationModule().provideNavigator(), NavigationModule().provideNavigator())
    }
}