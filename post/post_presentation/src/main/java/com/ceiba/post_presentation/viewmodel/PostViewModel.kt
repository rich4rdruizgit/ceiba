package com.ceiba.post_presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ceiba.core.R
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
    private val postUsesCases: PostUsesCases
) : ViewModel() {

    var state by mutableStateOf(PostViewState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()


    fun onEvent(event: PostViewEvent) {
        when (event) {
            is PostViewEvent.OnGetPosts -> {
                executeGetPost()
            }
        }
    }

    private fun executeGetPost() {
        viewModelScope.launch {
            state = state.copy(
                isGetPostService = false,
                posts = emptyList()
            )
            postUsesCases
                .getPosts()
                .onSuccess { posts ->
                    state = state.copy(
                        posts = posts.map {
                            PostViewUiState(it)
                        },
                        isGetPostService = true
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

}