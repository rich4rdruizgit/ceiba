package com.ceiba.users_presentation.list

data class UserViewState(
    val getUsers: List<UserViewUiState> = emptyList(),
    val isGetUserService: Boolean = false,
    val isHintVisible: Boolean = false,
    val isSearching: Boolean = false,
    val query:String = ""
)
