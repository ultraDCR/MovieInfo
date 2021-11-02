package com.ultradcr.movie_interactors

import com.ultradcr.core.DataState
import com.ultradcr.core.ProgressBarState
import com.ultradcr.core.UIComponent
import com.ultradcr.movie_datasource.cache.MovieCache
import com.ultradcr.movie_datasource.network.MovieService
import com.ultradcr.movie_domain.Movie
import com.ultradcr.movie_domain.MovieHome
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMovie(
    private val cache: MovieCache,
    private val service: MovieService
) {
    fun execute(movieId:String): Flow<DataState<Movie>> = flow{
        try{
            emit(
                DataState.Loading<Movie>(progressBarState = ProgressBarState.Loading)
            )

            delay(2000)
            val movie: Movie? = try{
                service.getMovieById(movieId)
            }catch (e: Exception){
                e.printStackTrace()
                emit(
                    DataState.Response<Movie>(
                        uiComponent = UIComponent.Dialog(
                            title = "Error",
                            description = e.message ?: "Unknown Error"
                        )
                    )
                )
                null
            }
            println(movie.toString())
            //cache the network data
            movie?.let{
                cache.insertMovie(movie)
            }
            //emit data from cache
            val cachedMovies = cache.getMovie(movieId)
            emit(
                DataState.Data<Movie>(cachedMovies)
            )

        }catch (e: Exception){
            e.printStackTrace()
            emit(
                DataState.Response<Movie>(
                    uiComponent = UIComponent.Dialog(
                        title = "Error",
                        description = e.message ?: "Unknown Error"
                    )
                )
            )
        }
        finally {
            emit(DataState.Loading<Movie>(progressBarState = ProgressBarState.Idle))
        }
    }
}