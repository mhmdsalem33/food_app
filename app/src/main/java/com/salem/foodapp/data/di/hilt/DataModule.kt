package com.salem.foodapp.data.di.hilt

import android.content.Context
import com.salem.foodapp.data.data_source.local.preferences.shared_preferences.SharedPreferencesManager
import com.salem.foodapp.data.data_source.local.preferences.shared_preferences.SharedPreferencesManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideSharedPreferencesManager(@ApplicationContext context: Context): SharedPreferencesManager = SharedPreferencesManagerImpl(context)

}