package com.ceiba.users_presentation.list.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ceiba.core.R
import com.ceiba.core.utils.UiEvent
import com.ceiba.core.utils.UiText
import com.ceiba.users_domain.use_cases.UsersUseCases
import com.ceiba.users_presentation.list.UserEvent
import com.ceiba.users_presentation.list.UserViewState
import com.ceiba.users_presentation.list.UserViewUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetUsersViewModel @Inject constructor(private val usersUseCases: UsersUseCases) :
    ViewModel() {
    var state by mutableStateOf(UserViewState())
        private set
    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: UserEvent) {
        when (event) {
            is UserEvent.onGetUsers -> {
                getUsers()
            }

            is UserEvent.OnSearch -> {
                searchUserByName()
            }
        }
    }

    private fun getUsers() {
        viewModelScope.launch {
            state = state.copy(
                isGetUserService = false,
                getUsers = emptyList()
            )
            usersUseCases.getUsers()
                .onSuccess { users ->
                    state = state.copy(
                        getUsers = users.map {
                            UserViewUiState(it)
                        },
                        isGetUserService = true
                    )
                }
                .onFailure {
                    state = state.copy(getUsers = emptyList())
                    _uiEvent.send(
                        UiEvent.ShowSnackbar(
                            UiText.StringResource(R.string.error_something_went_wrong)
                        )
                    )
                }
        }
    }

    private fun searchUserByName() {
        viewModelScope.launch {
            state = state.copy(
                isSearching = true,
                getUsers = emptyList()
            )
            usersUseCases.getUsersByName(state.query)
                .onSuccess { users ->
                    state = state.copy(
                        getUsers = users.map {
                            UserViewUiState(it)
                        },
                        isSearching = false
                    )
                }
                .onFailure {
                    state = state.copy(isSearching = false)
                    _uiEvent.send(
                        UiEvent.ShowSnackbar(
                            UiText.StringResource(R.string.error_something_went_wrong)
                        )
                    )
                }
        }
    }

}