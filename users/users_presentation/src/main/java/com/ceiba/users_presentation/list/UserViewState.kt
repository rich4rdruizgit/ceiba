package com.ceiba.users_presentation.list

data class UserViewState(
    val getUsers: List<UserViewUiState> = emptyList(),
    val isGetUserService: Boolean = false,
)
