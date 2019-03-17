package com.architecture.clean.presentation.di.module.base

/**
 * This is the abstract class for modules with the strong reference type.
 */
abstract class AbstractModule<T> {
    var instance: T? = null
}