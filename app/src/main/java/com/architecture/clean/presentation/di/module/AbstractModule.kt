package com.architecture.clean.presentation.di.module

import java.lang.ref.Reference

/**
 * Abstract module.
 *
 * All modules should wrap their held objects with SoftReference.
 */
abstract class AbstractModule<T, K : Reference<T>> {
    private var reference: K? = null

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

    fun getInstance(createInstance: () -> T): T {
        var instance = reference?.get()
        if (instance == null) {
            instance = createInstance()
            reference = createReference(instance)
        }
        return instance!!
    }

    // todo make abtract
    open fun createReference(instance: T): K? {
        return null
    }
}