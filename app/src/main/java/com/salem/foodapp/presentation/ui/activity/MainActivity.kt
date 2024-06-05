package com.salem.foodapp.presentation.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.salem.foodapp.presentation.navigation.NestedNavGraph
import com.salem.foodapp.presentation.ui.activity.screens.auth.onboarding.OnBoardingViewModel
import com.salem.foodapp.presentation.ui.theme.FoodAppTheme
import dagger.hilt.android.AndroidEntryPoint


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



