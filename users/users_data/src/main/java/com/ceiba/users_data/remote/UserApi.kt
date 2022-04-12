package com.ceiba.users_data.remote

import com.ceiba.users_data.remote.dto.UserDto
import retrofit2.http.GET

interface UserApi {

    @GET("users")
    suspend fun getUsers() : UserDto

}