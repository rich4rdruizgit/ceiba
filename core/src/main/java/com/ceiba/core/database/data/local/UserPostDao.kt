package com.ceiba.core.database.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ceiba.core.database.domain.entities.UserEntity
import com.ceiba.core.utils.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface UserPostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)

    @Query("SELECT * FROM ${Constants.USERS_ROOM_DATABASE_TABLE}")
    fun getAllUsers(): Flow<List<UserEntity>>
}