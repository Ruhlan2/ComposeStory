package com.ruhlan.composestory.v1

import android.media.session.PlaybackState.CustomAction
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ruhlan.composestory.LinearIndicator
import com.ruhlan.composestory.ui.theme.ComposeStoryTheme

/**
 * Created by r.usubov on 26.02.25.
 */

@Composable
fun CustomLinearIndicator(
    modifier: Modifier = Modifier,
) {
    LinearProgressIndicator(
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun CustomAction() {
    ComposeStoryTheme {
        CustomLinearIndicator()
    }
}