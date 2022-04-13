package com.ceiba.post_presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ceiba.core.R
import com.ceiba.core.utils.Constants
import com.ceiba.core.utils.UiEvent
import com.ceiba.core.utils.UiText
import com.ceiba.post_domain.use_case.PostUsesCases
import com.ceiba.post_presentation.PostViewEvent
import com.ceiba.post_presentation.PostViewState
import com.ceiba.post_presentation.PostViewUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val postUsesCases: PostUsesCases, savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(PostViewState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    var userId:String = ""


    init {
        savedStateHandle.get<String>(Constants.USER_ID)?.let { id ->
            executePostByUser(id.toInt())
        }
    }

    private fun executeGetPost() {
        viewModelScope.launch {
            state = state.copy(
                posts = emptyList()
            )
            postUsesCases
                .getPosts()
                .onSuccess { posts ->
                    state = state.copy(
                        posts = posts.map {
                            PostViewUiState(it)
                        },
                    )
                }
                .onFailure {
                    _uiEvent.send(
                        UiEvent.ShowSnackbar(
                            UiText.StringResource(R.string.no_results)
                        )
                    )
                }

        }
    }

    private fun executePostByUser(userId: Int) {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                posts = emptyList(),
                postsByUser = emptyList()
            )
            postUsesCases
                .getPostByUser(userId)
                .onSuccess  { posts ->
                    state = state.copy(
                        postsByUser = posts.map {
                            PostViewUiState(it)
                        },
                        isLoading = false
                    )
                }
                .onFailure {
                    state = state.copy(isLoading = false)
                    _uiEvent.send(
                        UiEvent.ShowSnackbar(
                            UiText.StringResource(R.string.no_results)
                        )
                    )
                }

        }
    }

}