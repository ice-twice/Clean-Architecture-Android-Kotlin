package com.architecture.clean.presentation.di.module.base

import java.lang.ref.Reference

/**
 * Abstract module class for modules which uses different types of references apart from the
 * strong type.
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