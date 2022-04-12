package com.ceiba.users_presentation.list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.ceiba.core.R
import com.ceiba.core_ui.util.LocalSpacing
import com.ceiba.users_presentation.list.UserEvent
import com.ceiba.users_presentation.list.viewmodel.GetUsersViewModel

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@Composable
fun ListUserScreen(
    scaffoldState: ScaffoldState,
    onNavigateUp: () -> Unit,
    viewModel: GetUsersViewModel = hiltViewModel()
){
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

            if (!state.isGetUserService) {
                viewModel.onEvent(UserEvent.onGetUsers)
            } else {
                items(state.getUsers) { userDetail ->
                    UserItem(
                        userUiState = userDetail,
                        onClick = { /*TODO*/ },
                    )

                }
            }

        }

    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when {
            !state.isGetUserService -> CircularProgressIndicator()
            state.getUsers.isEmpty() -> {
                Text(
                    text = stringResource(id = R.string.no_results),
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center
                )

            }
        }

    }

}
