package com.ceiba.core.di

import android.app.Application
import androidx.room.Room
import com.ceiba.core.database.data.local.UserPostDao
import com.ceiba.core.database.data.local.UserPostDatabase
import com.ceiba.core.database.data.repository.UserPostRepositoryImpl
import com.ceiba.core.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    fun provideUserPostDatabase(app:Application): UserPostDatabase {
        return Room.databaseBuilder(
            app,
            UserPostDatabase::class.java,
            Constants.ROOM_DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    @Named("userpostdao")
    fun provideUserPostRepositoryImpl():UserPostDao{
        return UserPostRepositoryImpl()
    }

}