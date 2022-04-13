package com.ceiba.users_presentation.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import com.ceiba.core_ui.util.LocalSpacing
import com.ceiba.users_presentation.list.UserViewUiState


@ExperimentalCoilApi
@Composable
fun UserItem(
    userUiState: UserViewUiState,
    onItemClick: (String) -> Unit
) {
    val user = userUiState.user
    val spacing = LocalSpacing.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { },
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W600,
                            color = Color(0xFF428646),
                            fontSize = 22.sp
                        )
                    ) {
                        append(user.name)
                    }
                }
            )
            Row {
                Icon(
                    imageVector = Icons.Rounded.Phone,
                    contentDescription = "phone",
                    tint = Color(0xFF428646)
                )
                Spacer(modifier = Modifier.width(spacing.spaceExtraSmall))
                Text(text = user.phone?:"")
            }
            Row {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = "email",
                    tint = Color(0xFF428646)
                )
                Spacer(modifier = Modifier.width(spacing.spaceExtraSmall))
                Text(text = user.email)
            }
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Column(
                modifier = Modifier.fillMaxWidth(),

            ) {
                Button(
                    modifier = Modifier.align(Alignment.End),
                    onClick = { onItemClick(user.id.toString())},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ) {
                    Text("Ver Publicaciones", color = Color(0xFF428646), fontSize = 18.sp)
                }
            }
        }
    }
}