package com.architecture.clean.presentation.presenter.component

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * The live data wrapper which can be stopped and then started again.
 */
class StoppableLiveData<T> : MutableLiveData<T>() {
    var stopped = false

    fun value(value: T?): StoppableLiveData<T> {
        this.stopped = false
        super.setValue(value)
        return this
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner, Observer<T> {
            if (!stopped) {
                observer.onChanged(it)
            }
        })
    }
}