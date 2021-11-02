package com.ultradcr.ui_moviedetails.ui

import com.ultradcr.core.ProgressBarState
import com.ultradcr.movie_domain.Movie

data class MovieDetailState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val movie: Movie? = null

    )