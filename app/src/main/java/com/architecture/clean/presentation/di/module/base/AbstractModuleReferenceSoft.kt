package com.architecture.clean.presentation.di.module.base

import java.lang.ref.SoftReference

/**
 * Abstract module class for modules which uses the soft reference type of instances.
 */

abstract class AbstractModuleReferenceSoft<T> : AbstractModuleReference<T, SoftReference<T>>() {

    override fun createReference(instance: T): SoftReference<T>? {
        return SoftReference(instance)
    }
}