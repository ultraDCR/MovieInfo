package com.ultradcr.ui_movielist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import com.ultradcr.components.CoilImage
import com.ultradcr.movie_domain.MovieHome



@Composable
fun MovieHomeListItem(
    modifier:Modifier = Modifier,
    movieHome: MovieHome,
    imageLoader: ImageLoader,
    onSelectMovie: (String) -> Unit
) {
   Surface(
       elevation = 3.dp,
       shape = RoundedCornerShape(8.dp),
       color = MaterialTheme.colors.surface,
       modifier = modifier.fillMaxWidth().aspectRatio(9/14f)
   ) {
      Box(modifier = Modifier.clickable {
          onSelectMovie(movieHome.id)
      }){
          movieHome.apply {
                CoilImage(imageLoader = imageLoader,imageUrl = image, contentScale = ContentScale.Crop)
                Box(
                    modifier = Modifier
                        .background(
                            brush = verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black),
                            )
                        )
                        .fillMaxWidth()
                        .fillMaxHeight(1/2f)
                        .align(Alignment.BottomCenter)
                        .padding(8.dp)

                ){
                    Text(
                        text = title,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                        modifier = Modifier.align(
                            Alignment.BottomCenter
                        )
                    )
                }

          }
      }
    }
}