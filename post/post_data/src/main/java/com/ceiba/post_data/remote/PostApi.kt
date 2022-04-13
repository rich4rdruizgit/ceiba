package com.ceiba.post_data.remote

import com.ceiba.post_data.remote.dto.PostDto
import retrofit2.http.GET

interface PostApi {

    @GET("/posts")
    suspend fun getPosts():List<PostDto>
}