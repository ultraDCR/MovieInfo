package com.ultradcr.movieinfo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import com.ultradcr.movieinfo.ui.navigation.Screen
import com.ultradcr.movieinfo.ui.theme.MovieInfoTheme
import com.ultradcr.ui_moviedetails.ui.MovieDetailViewModel
import com.ultradcr.ui_moviedetails.ui.MovieDetails
import com.ultradcr.ui_movielist.ui.HomeMovieList
import com.ultradcr.ui_movielist.ui.HomeMovieListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var imageLoader: ImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            MovieInfoTheme {
                Surface(color = MaterialTheme.colors.background) {}
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screen.HomeMovieList.route,
                    builder = {

                        addHomeMovieList(navController = navController, imageLoader = imageLoader)
                        addMovieDetail(navController = navController, imageLoader = imageLoader)

                    }
                )
            }
        }
    }
}


fun NavGraphBuilder.addHomeMovieList(
    navController: NavController,
    imageLoader: ImageLoader
){
    composable(
        route = Screen.HomeMovieList.route
    ) {
        val viewModel: HomeMovieListViewModel = hiltViewModel()
        HomeMovieList(
            state = viewModel.state.value,
            imageLoader = imageLoader,
            navigateToDetailsScreen = {movieId->
                navController.navigate("${Screen.MovieDetail.route}/$movieId")
            }
        )
    }
}


fun NavGraphBuilder.addMovieDetail(
    navController: NavController,
    imageLoader: ImageLoader
){
    composable(
        route = "${Screen.MovieDetail.route}/{movieId}",
        arguments = Screen.MovieDetail.arguments
    ){
        val viewModel: MovieDetailViewModel = hiltViewModel()

        MovieDetails(
            state = viewModel.state.value,
            imageLoader = imageLoader
        )
    }
}

