package com.architecture.clean.presentation.di.module

import com.architecture.clean.presentation.view.util.AndroidUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * The module to provide utils.
 */
@Module
class AndroidUtilModule {
    private val androidUtils by lazy(mode = LazyThreadSafetyMode.NONE) {
        AndroidUtil()
    }

    @Provides
    @Singleton
    internal fun provideAndroidUtil(): AndroidUtil {
        return androidUtils
    }
}