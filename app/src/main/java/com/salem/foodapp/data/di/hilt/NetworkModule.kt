package com.salem.foodapp.data.di.hilt

import com.salem.foodapp.data.data_source.remote.api.AuthServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory


@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
//    init {
//        System.loadLibrary("native-lib")
//    }
//    private external fun getEncryptedBaseUrl(): String
//


    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Provides
    @Singleton
    fun provideHeadersInterceptor() =
        Interceptor { chain ->
            chain.proceed(
                chain.request().newBuilder()
                    .apply {
                        header("Accept"          , "application/json")
                        header("Accept-Language" ,  "en")
                    }
                    .build()
            )
        }

    @Provides
    @Singleton
    fun provideOkhttp(logging: HttpLoggingInterceptor, headersInterceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(20 , TimeUnit.SECONDS)
            .readTimeout(   20 , TimeUnit.SECONDS)
            .addInterceptor( logging ) // Add logging interceptor
            .addInterceptor( headersInterceptor ) // Add headers interceptor

            .build()

    @Provides
    @Singleton
    fun provideApi( okHttpClient: OkHttpClient ) : Retrofit =
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit) : AuthServices =
        retrofit.create(AuthServices::class.java)






}