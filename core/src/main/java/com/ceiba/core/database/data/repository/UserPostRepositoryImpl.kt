package com.ceiba.core.database.data.repository

import com.ceiba.core.database.data.local.UserPostDao
import com.ceiba.core.database.domain.entities.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class UserPostRepositoryImpl : UserPostDao {
    override suspend fun insertUser(userEntity: UserEntity) {
        user = userEntity
    }

    override fun getAllUsers(): Flow<List<UserEntity>> = users

    companion object {
        private var user: UserEntity? = null
        private var users: Flow<List<UserEntity>> = emptyFlow()
    }
}