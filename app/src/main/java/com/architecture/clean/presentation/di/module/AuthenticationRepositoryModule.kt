package com.architecture.clean.presentation.di.module

import android.content.Context
import com.architecture.clean.data.AuthenticationRepositoryImpl
import com.architecture.clean.domain.repository.AuthenticationRepository
import com.architecture.clean.presentation.util.AndroidUtil
import dagger.Module
import dagger.Provides
import java.lang.ref.SoftReference
import javax.inject.Singleton

@Module
class AuthenticationRepositoryModule : AbstractModule() {
    private var authenticationRepository: SoftReference<AuthenticationRepository>? = null


    @Provides
    @Singleton
    internal fun provideAuthenticationRepository(androidUtil: AndroidUtil, context: Context): AuthenticationRepository {
        val pair = getOrCreateInstance(authenticationRepository, { AuthenticationRepositoryImpl(context, androidUtil) }, { instance -> SoftReference(instance) })
        authenticationRepository = pair.second
        return pair.first
    }
}