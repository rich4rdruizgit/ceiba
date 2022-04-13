package com.ceiba.post_data.remote

import com.ceiba.post_data.remote.dto.PostDto
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApi {

    @GET("/posts")
    suspend fun getPosts():List<PostDto>

    @GET("/posts/?")
    suspend fun getPostByUser(@Query("userId") userId: Int):List<PostDto>
}