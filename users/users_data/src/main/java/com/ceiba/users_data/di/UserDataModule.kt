package com.ceiba.users_data.di

import com.ceiba.core.database.data.local.UserPostDao
import com.ceiba.core.utils.Constants
import com.ceiba.users_data.remote.UserApi
import com.ceiba.users_data.repository.UserRepositoryImpl
import com.ceiba.users_domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserDataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideUserApi(client: OkHttpClient): UserApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        api: UserApi,
        @Named("userpostdao") dao: UserPostDao
    ): UserRepository {
        return UserRepositoryImpl(
            api = api,
            dao = dao
        )
    }
}