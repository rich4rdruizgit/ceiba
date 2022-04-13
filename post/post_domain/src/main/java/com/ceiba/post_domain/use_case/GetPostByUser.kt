package com.ceiba.post_domain.use_case

import com.ceiba.post_domain.model.Post
import com.ceiba.post_domain.repository.PostRepository

class GetPostByUser(
    private val repository: PostRepository
) {
    suspend operator fun invoke(userId: Int): Result<List<Post>> {
        return repository.getPostByUser(userId)
    }
}