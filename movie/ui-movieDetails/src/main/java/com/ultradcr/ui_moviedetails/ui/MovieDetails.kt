package com.ultradcr.ui_moviedetails.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import com.ultradcr.components.CoilImage
import com.ultradcr.core.ProgressBarState

@Composable
fun MovieDetails(
    state: MovieDetailState,
    imageLoader: ImageLoader
) {


    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Blue.copy(alpha = 0.3f))
            .padding(8.dp)
    ) {
        LazyColumn(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            item {
                state.movie?.run {
                    CoilImage(
                        modifier = Modifier
                            .fillMaxWidth(1 / 2f)
                            .aspectRatio(9 / 14f)
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop,
                        imageLoader = imageLoader,
                        imageUrl = image,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        title,
                        style = MaterialTheme.typography.h5,
                        fontFamily = FontFamily.Monospace
                    )
                    Text(
                        text = "Released on: $releaseDate",
                        style = MaterialTheme.typography.overline
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(16.dp))

                    LazyRow(Modifier.fillMaxWidth()) {
                        items(genreList) { genre ->
                            Surface(
                                elevation = 2.dp,
                                shape = RoundedCornerShape(50),
                                color = Color.Blue,
                                modifier = Modifier.padding(4.dp)
                            ) {
                                Text(
                                    text = genre.value ?: "",
                                    color = Color.White,
                                    style = MaterialTheme.typography.overline,
                                    modifier = Modifier.padding(
                                        vertical = 4.dp,
                                        horizontal = 8.dp
                                    )
                                )
                            }
                        }
                    }
                    Card(elevation = 4.dp, modifier = Modifier.padding(4.dp)) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "Film Plot",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = plot, style = MaterialTheme.typography.body2)
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Card(elevation = 4.dp, modifier = Modifier.padding(4.dp)) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "Cast",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(10.dp))

                            actorList.chunked(2).map { actors ->
                                Row(modifier = Modifier.fillMaxWidth()) {
                                    actors.map { actor ->
                                        Row(modifier = Modifier.fillParentMaxWidth(1/2f).padding(4.dp)) {
                                            CoilImage(
                                                imageLoader = imageLoader,
                                                imageUrl = actor.image ?: "",
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier.size(40.dp).clip(
                                                    RoundedCornerShape(8.dp))
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Column() {
                                                Text(
                                                    text = actor.name ?: "",
                                                    style = MaterialTheme.typography.body2
                                                )
                                                Text(
                                                    text = "(${actor.asCharacter})",
                                                    style = MaterialTheme.typography.overline
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }


                }

            }


        }
        if (state.progressBarState is ProgressBarState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }

}


