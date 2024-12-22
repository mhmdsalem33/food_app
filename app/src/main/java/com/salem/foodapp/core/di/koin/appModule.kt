package com.salem.foodapp.core.di.koin

import android.util.Log
import com.salem.foodapp.data.di.koin.dataModule
import com.salem.foodapp.data.di.koin.networkModule
import org.koin.dsl.module
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json

val appModule = module {
    includes(   networkModule , dataModule )









//    single {
//        HttpClient(CIO) {
//            install(JsonFeature) {
//                serializer = KotlinxSerializer()
//            }
//        }
//    }
//
//    // Provide ApiService
//    single<ApiService> { ApiServiceImpl(get()) }
//
//    // Provide Repository
//    single<Repository> { RepositoryImpl(get()) }
//
//    // Provide Use Case
//    single { LoginUseCase(get()) }
//
//    // Provide ViewModel
//    viewModel { MainViewModel(get()) }

}