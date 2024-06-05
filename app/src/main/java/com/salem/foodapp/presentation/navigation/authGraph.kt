package com.salem.foodapp.presentation.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
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
    composable<OnBoardingScreen>(
        enterTransition = {
            EnterTransition.None
        },
        exitTransition = {
            ExitTransition.None
        },
        popExitTransition = {
            ExitTransition.None
        },
        popEnterTransition = {
            EnterTransition.None
        }

    )
    {
        OnboardingScreen(navController  , onBoardingViewModel )
    }

    composable<LoginScreen>(
        enterTransition = {
            EnterTransition.None
        },
        exitTransition = {
            ExitTransition.None
        },
        popExitTransition = {
            ExitTransition.None
        },
        popEnterTransition = {
            EnterTransition.None
        }
    )
    {
        LoginScreen(navController)
    }

}

@Serializable
object LoginScreen


@Serializable
object OnBoardingScreen

