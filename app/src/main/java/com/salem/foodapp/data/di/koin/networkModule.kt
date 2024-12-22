package com.salem.foodapp.data.di.koin

import android.util.Log
import com.salem.foodapp.data.data_source.remote.api.ApiService
import com.salem.foodapp.data.data_source.remote.api.AuthService
import com.salem.foodapp.data.repo.auth.LoginRepoImpl
import com.salem.foodapp.data.repo.home.HomeRepositoryImpl
import com.salem.foodapp.domain.repo.auth.LoginRepository
import com.salem.foodapp.domain.repo.home.HomeRepository
import com.salem.foodapp.domain.usecases.main.GetRecipesUseCase
import com.salem.foodapp.domain.usecases.auth.LoginUseCase
import com.salem.foodapp.domain.usecases.main.GetProductsUseCase
import com.salem.foodapp.domain.usecases.main.GetSearchUseCase
import com.salem.foodapp.presentation.ui.activity.screens.auth.login.LoginViewModel
import com.salem.foodapp.presentation.ui.activity.screens.main.home_screen.HomeViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import kotlin.math.sin


val networkModule = module {

    // KTOR
    single {
        HttpClient(CIO) {

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.e("KtorLogger", message) // Log to Android Logcat
                    }
                }
                level = LogLevel.ALL // Log everything (HEADERS, BODY, INFO , NONE ,  etc.)
            }

            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true // Avoid errors for unexpected fields
                    prettyPrint = true
                })
            }

            // Default Request Plugin (Global Headers)
            install(DefaultRequest) {
                header(HttpHeaders.ContentType, ContentType.Application.Json) // Set default Content-Type
//           header(HttpHeaders.Authorization, "Bearer YOUR_API_TOKEN") // Example: Authorization header
            }
        }

    }


    // ApiService
    single { AuthService(get()) }

    // login Repository
    single<LoginRepository> { LoginRepoImpl(get()) }


    // login use case
    factory { LoginUseCase(get()) }


    //Login View Model
    viewModel { LoginViewModel(get()) }


    single { ApiService(get()) }


    singleOf(::HomeRepositoryImpl){
        bind<HomeRepository>()
    }


    single { GetRecipesUseCase(get()) }

    single { GetProductsUseCase(get()) }

    single { GetSearchUseCase(get()) }


    viewModel { HomeViewModel(get() , get() , get()) }

}