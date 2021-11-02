package com.ultradcr.movieinfo.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.navArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument>
){

    object HomeMovieList:Screen(
        route = "homeMovieList",
        arguments = emptyList()
    )

    object MovieDetail: Screen(
        route = "movieDetails",
        arguments = listOf(
            navArgument(
                name = "movieId",
            ){
                type = NavType.StringType
            }
        )
    )
}
