package com.architecture.clean.presentation.di.module

import java.lang.ref.Reference

/**
 * Abstract module.
 *
 * All modules should wrap their held objects with SoftReference.
 */
abstract class AbstractModule {
    fun <T, K : Reference<T>> getOrCreateInstance(reference: K?, createInstance: () -> T, createReference: (T) -> K): Pair<T, K> {
        var instance = reference?.get()
        val newReference: K?

        if (instance == null) {
            instance = createInstance()!!
            newReference = createReference(instance)
        } else {
            newReference = reference!!
        }

        return Pair(instance, newReference)
    }
}