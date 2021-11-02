package com.ultradcr.ui_movielist.ui

import com.ultradcr.core.ProgressBarState
import com.ultradcr.movie_domain.MovieHome

data class MovieHomeListState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val movieHome: List<MovieHome> = listOf()
)
