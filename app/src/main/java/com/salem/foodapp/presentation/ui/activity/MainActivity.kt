package com.salem.foodapp.presentation.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.salem.foodapp.data.models.auth.login.LoginRequest
import com.salem.foodapp.domain.repo.auth.LoginRepository
import com.salem.foodapp.domain.usecases.auth.LoginUseCase
import com.salem.foodapp.presentation.navigation.NestedNavGraph
import com.salem.foodapp.presentation.ui.activity.screens.auth.onboarding.OnBoardingViewModel
import com.salem.foodapp.presentation.ui.activity.screens.main.home_screen.HomeViewModel
import com.salem.foodapp.presentation.ui.theme.FoodAppTheme
import dagger.hilt.android.AndroidEntryPoint
import io.ktor.client.*
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.request.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.koinViewModel


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val onBoardingMvvm : OnBoardingViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { false }

        super.onCreate(savedInstanceState)


        setContent {
            FoodAppTheme {
                NestedNavGraph(onBoardingViewModel = onBoardingMvvm)
            }
        }
    }
}



