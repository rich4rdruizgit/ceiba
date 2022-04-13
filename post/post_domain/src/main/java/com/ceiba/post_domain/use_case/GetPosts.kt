package com.ceiba.post_domain.use_case

import com.ceiba.post_domain.model.Post
import com.ceiba.post_domain.repository.PostRepository

class GetPosts(private val repository: PostRepository) {
    suspend operator fun invoke(): Result<List<Post>> {
        return repository.getPosts()
    }
}