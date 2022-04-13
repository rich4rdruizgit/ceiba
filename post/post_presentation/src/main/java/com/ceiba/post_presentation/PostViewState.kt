package com.ceiba.post_presentation

data class PostViewState(
    val posts: List<PostViewUiState> = emptyList(),
    val isLoading: Boolean = false,
    val postsByUser: List<PostViewUiState> = emptyList()
)
