package com.ceiba.post_domain.repository

import com.ceiba.post_domain.model.Post

interface PostRepository {
    suspend fun getPosts(): Result<List<Post>>
    suspend fun getPostByUser(userId: Int): Result<List<Post>>
}