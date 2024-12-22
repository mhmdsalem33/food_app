package com.salem.foodapp.domain.di

import com.salem.foodapp.data.data_source.remote.api.AuthServices
import com.salem.foodapp.data.repo.home.HomeRepositoryImpl
import com.salem.foodapp.domain.repo.home.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

//
//    @Singleton
//    @Provides
//    fun provideHomeRepository(authServices: AuthServices) : HomeRepository = HomeRepositoryImpl(authServices)

}