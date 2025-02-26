package com.ruhlan.composestory.story

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import coil3.network.NetworkHeaders
import coil3.network.httpHeaders
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.ruhlan.composestory.R
import com.ruhlan.composestory.Stories
import com.ruhlan.composestory.model.snapList
import kotlinx.coroutines.delay

/**
 * Created by r.usubov on 25.02.25.
 */

@Composable
fun SubStoryScreen(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold {
        Stories(numberOfPages = snapList.size,
            onEveryStoryChange = { position ->
                Log.i("DATA", "Story Change $position")
            },
            onComplete = {
                navController.navigate("dashboard")
            }) { index ->
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .crossfade(true)
                    .httpHeaders(
                        NetworkHeaders.Builder()
                            .set("User-Agent", "Mozilla/5.0")
                            .build()
                    )
                    .data(snapList[index].url)
                    .build(),
                contentDescription = null,
                modifier = modifier
                    .fillMaxSize()
                    .padding(it),
                placeholder = painterResource(R.drawable.ic_launcher_background),
                error = painterResource(R.drawable.ic_launcher_foreground)
            )
        }
    }
}

