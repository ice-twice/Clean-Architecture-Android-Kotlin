package com.architecture.clean.presentation.di.module

import java.lang.ref.SoftReference

abstract class AbstractModule<T> {
    protected lateinit var reference: SoftReference<T?>

    protected fun getInstance(createInstance: () -> T): T {
        if (!::reference.isInitialized) {
            reference = SoftReference(null)
        }

        var instance = reference.get()
        if (instance == null) {
            instance = createInstance()
            reference = SoftReference(instance)
        }
        // shouldn't be null
        return instance!!
    }

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