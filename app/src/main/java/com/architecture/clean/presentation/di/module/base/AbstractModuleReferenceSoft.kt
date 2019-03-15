package com.architecture.clean.presentation.di.module.base

import java.lang.ref.SoftReference

abstract class AbstractModuleReferenceSoft<T> : AbstractModuleReference<T, SoftReference<T>>() {

    override fun createReference(instance: T): SoftReference<T>? {
        return SoftReference(instance)
    }
}