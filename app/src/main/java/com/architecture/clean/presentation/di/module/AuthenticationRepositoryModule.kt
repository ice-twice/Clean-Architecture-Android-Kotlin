package com.architecture.clean.presentation.di.module

import android.content.Context
import com.architecture.clean.data.AuthenticationRepositoryImpl
import com.architecture.clean.domain.repository.AuthenticationRepository
import com.architecture.clean.presentation.util.AndroidUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AuthenticationRepositoryModule : AbstractModuleReferenceSoft<AuthenticationRepository>() {

    @Provides
    @Singleton
    internal fun provideAuthenticationRepository(androidUtil: AndroidUtil, context: Context): AuthenticationRepository {
        return getInstance { AuthenticationRepositoryImpl(context, androidUtil) }
    }
}