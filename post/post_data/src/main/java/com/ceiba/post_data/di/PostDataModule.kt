package com.ceiba.post_data.di

import android.app.Application
import androidx.room.Room
import com.ceiba.core.utils.Constants
import com.ceiba.post_data.remote.PostApi
import com.ceiba.post_data.repository.PostRepositoryImpl
import com.ceiba.post_domain.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PostDataModule {

    @Provides
    @Singleton
    fun provideOKHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
            .build()
    }

    @Provides
    @Singleton
    fun provideGetPostApi(client: OkHttpClient): PostApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }


    @Provides
    @Singleton
    fun providePostApiRepository(
        api: PostApi,
    ): PostRepository {
        return PostRepositoryImpl(
            api = api
        )
    }

}