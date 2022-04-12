package com.ceiba.users_domain.use_cases

import com.ceiba.users_domain.models.UserItem
import com.ceiba.users_domain.repository.UserRepository

class GetUsers(private val repository: UserRepository) {
    suspend operator fun invoke():Result<List<UserItem>>{
        return repository.getUsers()
    }
}