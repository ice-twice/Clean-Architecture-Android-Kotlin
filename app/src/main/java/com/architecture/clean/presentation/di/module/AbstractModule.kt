package com.architecture.clean.presentation.di.module

import java.lang.ref.SoftReference

/**
 * Abstract module.
 *
 * All modules should wrap their held objects with SoftReference.
 */
abstract class AbstractModule {
    fun <T> getOrCreateInstance(reference: SoftReference<T>?, createInstance: () -> T): Pair<T, SoftReference<T>> {
        var instance = reference?.get()
        val newReference: SoftReference<T>?

        if (reference == null || instance == null) {
            instance = createInstance()!!
            newReference = SoftReference(instance)
        } else {
            newReference = reference
        }

        return Pair(instance, newReference)
    }
}