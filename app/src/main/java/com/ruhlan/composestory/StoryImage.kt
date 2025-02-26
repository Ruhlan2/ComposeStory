package com.ruhlan.composestory

import android.view.MotionEvent
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInteropFilter

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun StoryImage(
    pagerState: PagerState,
    onTap: (Boolean) -> Unit,
    content: @Composable (Int) -> Unit
) {
    HorizontalPager(state = pagerState, modifier = Modifier.pointerInteropFilter {
        snapshotFlow {

        }
        when (it.action) {
            MotionEvent.ACTION_DOWN -> {
                onTap(true)
            }
            MotionEvent.ACTION_UP -> {
                onTap(false)
            }
        }
        true
    }) {
        content(it)
    }
}