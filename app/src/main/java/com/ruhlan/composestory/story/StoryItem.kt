package com.ruhlan.composestory.story

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.network.NetworkHeaders
import coil3.network.httpHeaders
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.ruhlan.composestory.R

@Composable
fun StoryItem(
    modifier: Modifier = Modifier,
    imageUrl: String,
    onClick: () -> Unit
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .crossfade(true)
            .httpHeaders(
                NetworkHeaders.Builder()
                    .build()
            )
            .data(imageUrl)
            .build(),
        contentDescription = null,
        modifier = modifier
            .padding(horizontal = 5.dp, vertical = 10.dp)
            .clip(CircleShape)
            .size(80.dp)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .clickable {
                onClick()
            },
        placeholder = painterResource(R.drawable.ic_launcher_background),
        error = painterResource(R.drawable.ic_launcher_foreground)
    )
}