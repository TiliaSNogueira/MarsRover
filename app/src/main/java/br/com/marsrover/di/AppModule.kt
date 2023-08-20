package br.com.marsrover.di

import br.com.marsrover.service.MarsRoverService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideMarRoverService(): MarsRoverService =
        MarsRoverService.create()

}