package com.ceiba.users_data.repository

import com.ceiba.core.database.data.local.UserPostDao
import com.ceiba.users_data.mapper.toUserEntity
import com.ceiba.users_data.mapper.toUserModel
import com.ceiba.users_data.mapper.toUserModelView
import com.ceiba.users_data.remote.UserApi
import com.ceiba.users_domain.models.UserItem
import com.ceiba.users_domain.repository.UserRepository
import kotlinx.coroutines.flow.*

class UserRepositoryImpl(private val api: UserApi, val dao: UserPostDao) : UserRepository {
    override suspend fun getUsers(): Result<List<UserItem>> {
        return try {
            val userDto = api.getUsers()

            var usersItems = userDto.map {
                it.toUserModelView()
            }

            var usersEntity= usersItems.map {
                it.toUserEntity()
            }

            usersEntity.map {
                dao.insertUser(it)
            }


            Result.success(
                userDto.mapNotNull {
                    it.toUserModelView()
                }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

}