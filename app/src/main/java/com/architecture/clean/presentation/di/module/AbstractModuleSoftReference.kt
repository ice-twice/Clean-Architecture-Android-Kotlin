package com.architecture.clean.presentation.di.module

import java.lang.ref.SoftReference

abstract class AbstractModuleSoftReference<T> : AbstractModule<T, SoftReference<T>>() {

    override fun createReference(instance: T): SoftReference<T>? {
        return SoftReference(instance)
    }
}