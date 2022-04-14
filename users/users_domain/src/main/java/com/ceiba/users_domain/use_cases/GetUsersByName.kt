package com.ceiba.users_domain.use_cases

import com.ceiba.users_domain.models.UserItem
import com.ceiba.users_domain.repository.UserRepository

class GetUsersByName(private val repository: UserRepository) {
    suspend operator fun invoke(query:String):Result<List<UserItem>>{
        return repository.getUsersByName(query)
    }
}