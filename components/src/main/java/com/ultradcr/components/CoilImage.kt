package com.ultradcr.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.size.Scale


@ExperimentalCoilApi
@Composable
fun CoilImage(
    modifier: Modifier = Modifier,
    imageLoader: ImageLoader,
    imageUrl: String,
    contentScale: ContentScale = ContentScale.Fit,
    @DrawableRes placeholder: Int  = android.R.color.darker_gray,
    @DrawableRes errorImage: Int  = android.R.color.darker_gray,
    contentDescription:String = "Image",
) {

    val scaleType = when(contentScale){
        ContentScale.Crop, ContentScale.FillBounds -> Scale.FILL
        else -> Scale.FIT
    }

    val painter = rememberImagePainter(
        data = imageUrl,
        imageLoader = imageLoader,
        builder = {
            scale(scaleType)
            crossfade(true)
            placeholder(drawableResId = placeholder)
            error(drawableResId = errorImage)
        },
    )

    painter.state is ImagePainter.State.Loading

    Box(modifier = modifier.showLoading(painter.state is ImagePainter.State.Loading)){
        Image(
            painter = painter,
            contentScale = contentScale,
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize().align(Alignment.Center)
        )

    }


}