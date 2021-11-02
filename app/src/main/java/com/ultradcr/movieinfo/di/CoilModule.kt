package com.ultradcr.movieinfo.di

import android.app.Application
import coil.ImageLoader
import com.ultradcr.movieinfo.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoilModule {
    @Provides
    @Singleton
    fun provideImageLoader(app: Application): ImageLoader {
        return ImageLoader.Builder(app)
            .error(android.R.color.darker_gray)
            .placeholder(android.R.color.darker_gray)
            .availableMemoryPercentage(0.25)
            .crossfade(true)
            .build()
    }
}