package com.architecture.clean.presentation.di.module

import java.lang.ref.Reference

/**
 * Abstract module.
 *
 * All modules should wrap their held objects with SoftReference.
 */
abstract class AbstractModuleReference<T, K : Reference<T>> {
    private var reference: K? = null

    fun getInstance(createInstance: () -> T): T {
        var instance = reference?.get()
        if (instance == null) {
            instance = createInstance()
            reference = createReference(instance)
        }
        return instance!!
    }

    abstract fun createReference(instance: T): K?
}