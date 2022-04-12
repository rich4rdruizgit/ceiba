package com.ceiba.users_data.remote

import com.ceiba.users_data.remote.dto.UserDto
import com.ceiba.users_data.remote.dto.UserItemDto
import retrofit2.http.GET

interface UserApi {

    @GET("/users")
    suspend fun getUsers() : List<UserItemDto>

}