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
}