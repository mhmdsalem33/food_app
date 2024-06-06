package com.salem.foodapp.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavBackStackEntry
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
        OnboardingScreen(navController  , onBoardingViewModel )
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



val noEnterTransition : AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition = {
    fadeIn(
        animationSpec = tween(durationMillis = 300),
        initialAlpha = 0.99f
    )
}

val noExitTransition : AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition = {
    fadeOut(
        animationSpec = tween(durationMillis = 300),
        targetAlpha = 0.99f
    )
}
