package com.ceiba.post_presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import com.ceiba.core_ui.util.LocalSpacing
import com.ceiba.post_presentation.PostViewUiState


@ExperimentalCoilApi
@Composable
fun PostItem(
    modifier: Modifier = Modifier,
    postDetail: PostViewUiState
) {
    val spacing = LocalSpacing.current
    val post = postDetail.post
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
                        append(post.title)
                    }
                }
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 14.sp
                        )
                    ) {
                        append(post.body)
                    }
                },
                textAlign = TextAlign.Justify
            )
        }
    }
}