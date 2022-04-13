package com.ceiba.core.database.data.repository

import com.ceiba.core.database.data.local.UserPostDao
import com.ceiba.core.database.domain.entities.UserEntity
import com.ceiba.core.database.domain.repository.UserPostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class UserPostRepositoryImpl(private val dao : UserPostDao):UserPostRepository {
    override suspend fun getAllUsers(): Flow<List<UserEntity>?> {
        return dao.getAllUsers()
    }

    override suspend fun insertUser(user: UserEntity) {
        return dao.insertUser(user)
    }

}