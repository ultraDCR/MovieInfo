package com.ultradcr.ui_moviedetails.di

import com.ultradcr.core.Logger
import com.ultradcr.movie_interactors.GetMovie
import com.ultradcr.movie_interactors.GetTop100Movies
import com.ultradcr.movie_interactors.MovieInterators
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieDetailModule {


    @Provides
    @Singleton
    fun provideGetMovie(
        interactors: MovieInterators
    ): GetMovie{
        return interactors.getMovie
    }

    @Provides
    @Singleton
    @Named("movieDetailLogger")
    fun provideLogger():Logger{
        return Logger(
            tag = "MovieDetail",
            isDebug = true
        )
    }


}