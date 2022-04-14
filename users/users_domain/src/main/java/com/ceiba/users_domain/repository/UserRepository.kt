package com.ceiba.users_domain.repository

import com.ceiba.users_domain.models.User
import com.ceiba.users_domain.models.UserItem

interface UserRepository {
    suspend fun getUsers(): Result<List<UserItem>>
    suspend fun getUsersByName(query:String): Result<List<UserItem>>
}