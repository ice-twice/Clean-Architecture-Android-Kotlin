package com.architecture.clean.presentation.di.module.base.reference

import java.lang.ref.Reference
import kotlin.reflect.KMutableProperty0

abstract class BaseModuleReference<T> {
    fun getInstance(referenceHolder: KMutableProperty0<Reference<T>?>, createInstance: () -> T): T {
        var instance = referenceHolder.get()?.get()
        if (instance == null) {
            instance = createInstance()
            referenceHolder.set(createReference(instance))
        }
        return instance!!
    }

    abstract fun createReference(instance: T): Reference<T>
}