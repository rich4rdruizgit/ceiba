package com.ceiba.post_presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import coil.annotation.ExperimentalCoilApi
import com.ceiba.core.R
import com.ceiba.core_ui.util.LocalSpacing
import com.ceiba.post_presentation.PostViewEvent
import com.ceiba.post_presentation.viewmodel.PostViewModel

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@Composable
fun PostScreen(
    viewModel: PostViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val state = viewModel.state
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = spacing.spaceMedium)
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = spacing.spaceMedium)
        ) {
            items(state.postsByUser) { postDetail ->
                PostItem(postDetail = postDetail)
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when {
            state.isLoading -> CircularProgressIndicator()
            state.postsByUser.isEmpty() -> {
                Text(
                    text = stringResource(id = R.string.no_results),
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center
                )

            }
        }

    }
}