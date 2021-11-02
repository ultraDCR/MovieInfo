package com.ultradcr.components

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.debugInspectorInfo
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.shimmer
import com.google.accompanist.placeholder.placeholder

fun Modifier.showLoading(show:Boolean): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "showLoading"
        value = show
        properties["show"] = show
    }
) {
    this.then(
        placeholder(
            visible = show,
            color = MaterialTheme.colors.secondaryVariant,
            shape = MaterialTheme.shapes.small,
            highlight = PlaceholderHighlight.shimmer(),
        )
    )
}
