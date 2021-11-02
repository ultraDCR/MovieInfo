package com.ultradcr.ui_movielist.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import com.ultradcr.core.ProgressBarState
import com.ultradcr.ui_movielist.components.MovieHomeListItem

@Composable
fun HomeMovieList(
    state: MovieHomeListState,
    imageLoader: ImageLoader,
    navigateToDetailsScreen: (String) -> Unit
) {
    Column() {
        Surface(elevation = 8.dp) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
                Text(text = "MovieINFO")
            }
        }
        Box(Modifier.fillMaxSize().padding(8.dp)) {
            LazyColumn {
                items(state.movieHome.chunked(3)) { movies ->
                    Row() {
                        movies.map { movie ->
                            MovieHomeListItem(
                                modifier = Modifier
                                    .fillParentMaxWidth(1 / 3f)
                                    .padding(2.dp),
                                movieHome = movie,
                                imageLoader = imageLoader
                            ) { movieId ->
                                navigateToDetailsScreen(movieId)
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

}