package com.ceiba.post_data.mapper

import com.ceiba.post_data.remote.dto.PostDto
import com.ceiba.post_domain.model.Post

fun PostDto.toPostModel(): Post {
    return Post(
        userId = userId,
        id = id,
        title = title,
        body = body
    )
}