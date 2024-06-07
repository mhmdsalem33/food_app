package com.salem.foodapp.presentation.navigation


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.salem.foodapp.presentation.ui.activity.screens.auth.login.LoginScreen
import com.salem.foodapp.presentation.ui.activity.screens.auth.onboarding.OnBoardingViewModel
import com.salem.foodapp.presentation.ui.activity.screens.auth.onboarding.OnboardingScreen
import kotlinx.serialization.Serializable

fun NavGraphBuilder.authGraph(
    navController: NavHostController,
    onBoardingViewModel: OnBoardingViewModel,
) {
    composable<OnBoardingScreen>
    {
        OnboardingScreen( navController , onBoardingViewModel )
    }

    composable<LoginScreen>
    {
        LoginScreen(navController)
    }
}

@Serializable
object LoginScreen

@Serializable
object OnBoardingScreen
