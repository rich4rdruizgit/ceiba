package com.ceiba.users_presentation.list

data class GetUserState(
    val getUsers: List<GetUserUiState> = emptyList()
)
