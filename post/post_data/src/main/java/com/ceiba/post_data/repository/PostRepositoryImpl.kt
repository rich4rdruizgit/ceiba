package com.ceiba.post_data.repository

import com.ceiba.post_data.mapper.toPostModel
import com.ceiba.post_data.remote.PostApi
import com.ceiba.post_domain.model.Post
import com.ceiba.post_domain.repository.PostRepository

class PostRepositoryImpl(
    private val api: PostApi
) : PostRepository {
    override suspend fun getPosts(): Result<List<Post>> {
        return try {
            val getPostDto = api.getPosts()
            Result.success(
                getPostDto.mapNotNull {
                    it.toPostModel()
                }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun getPostByUser(userId: Int): Result<List<Post>> {
        return  try {
            val getPostDto = api.getPostByUser(userId)
            Result.success(
                getPostDto.mapNotNull {
                    it.toPostModel()
                }
            )
        }catch (e: java.lang.Exception){
            e.printStackTrace()
            Result.failure(e)
        }
    }

}