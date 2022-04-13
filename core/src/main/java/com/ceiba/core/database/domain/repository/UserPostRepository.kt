package com.ceiba.core.database.domain.repository

import com.ceiba.core.database.domain.entities.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserPostRepository {
    suspend fun getAllUsers(): Flow<List<UserEntity>?>
    suspend fun insertUser(user: UserEntity)
}