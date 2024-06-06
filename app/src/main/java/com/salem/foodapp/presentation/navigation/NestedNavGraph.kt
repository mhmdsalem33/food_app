package com.salem.foodapp.presentation.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.salem.foodapp.presentation.ui.activity.screens.auth.onboarding.OnBoardingViewModel

@Composable
fun NestedNavGraph( onBoardingViewModel: OnBoardingViewModel  ) {

    val navController = rememberNavController()



    NavHost(
        navController = navController  ,
        startDestination =  determineStartDestination(onBoardingViewModel.isOnboardingCompleted) ,
        enterTransition = {  EnterTransition.None }, // Disable enter transition
        exitTransition = {  ExitTransition.None },   // Disable exit transition
        popEnterTransition = { EnterTransition.None }, // Disable pop enter transition
        popExitTransition = { ExitTransition.None }  // Disable pop exit transition
    ) {


        authGraph( navController , onBoardingViewModel)
//        mainGraph(navController)

    }

}


private fun determineStartDestination( isLoggedIn: Boolean = false ) : Any{
    return if (isLoggedIn) LoginScreen else OnBoardingScreen
}

