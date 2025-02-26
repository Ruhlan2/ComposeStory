package com.ruhlan.composestory.model

/**
 * Created by r.usubov on 25.02.25.
 */

data class StoryModel(
    val snapCount: Int,
    val snaps: List<SnapsUiModel>
) {
    data class SnapsUiModel(
        val id: String,
        val mimeType: String = "image",
        val title: String = "",
        val url: String,
        val thumbnail: String
    )
}

val snapList = listOf(

)

val storyModel = StoryModel(
    snapCount = snapList.size,
    snaps = snapList
)