package com.architecture.clean.presentation.di.module

import com.architecture.clean.presentation.util.AndroidUtil
import dagger.Module
import dagger.Provides
import java.lang.ref.SoftReference
import javax.inject.Singleton

/**
 * The module to provide utils.
 *
 * A soft reference is used to provide the same object for all clients and prevent creating redundant instances. This is like singleton behaviour but a held object can be removed if there are no references to it.
 */
@Module
class AndroidUtilModule {
    object Holder {
        var androidUtils: SoftReference<AndroidUtil?> = SoftReference(null)
    }

    @Provides
    @Singleton
    internal fun provideAndroidUtil(): AndroidUtil {
        var instance = Holder.androidUtils.get()
        if (instance == null) {
            instance = AndroidUtil()
            Holder.androidUtils = SoftReference(instance)
        }
        return instance
    }
}