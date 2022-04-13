package com.ceiba.post_presentation

data class PostViewState(
    val posts: List<PostViewUiState> = emptyList(),
    val isGetPostService: Boolean = false
)
