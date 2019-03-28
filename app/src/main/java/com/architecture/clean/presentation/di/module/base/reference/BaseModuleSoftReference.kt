package com.architecture.clean.presentation.di.module.base.reference

import java.lang.ref.Reference
import java.lang.ref.SoftReference

open class BaseModuleSoftReference<T> : BaseModuleReference<T>() {
    final override fun createReference(instance: T): Reference<T> = SoftReference(instance)
}