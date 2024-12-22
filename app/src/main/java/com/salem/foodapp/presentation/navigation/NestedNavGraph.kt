package com.salem.foodapp.presentation.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.salem.foodapp.presentation.ui.activity.screens.auth.onboarding.OnBoardingViewModel
import com.salem.foodapp.presentation.ui.activity.screens.main.home_screen.HomeViewModel

@Composable
fun NestedNavGraph( onBoardingViewModel: OnBoardingViewModel  ) {

    val navController = rememberNavController()

//    Surface(
//        modifier = Modifier.fillMaxSize(),
//        color = Color.White
//    ) {
//
//    }
    NavHost(
        navController = navController  ,
        startDestination   =  determine( isLoggedIn =  true  ,onBoardingViewModel.isOnboardingCompleted) ,
        enterTransition    = { EnterTransition.None },
        exitTransition     = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition  = { ExitTransition.None }
    ) {

        authGraph( navController , onBoardingViewModel)
        mainGraph(navController)

    }

}


private fun determineStartDestination( isLoggedIn: Boolean = true ) : Any{
    return if (isLoggedIn) LoginScreen else OnBoardingScreen

}

private fun determine( isLoggedIn : Boolean , onBoarding : Boolean) :Any {
    if (!onBoarding)
        return OnBoardingScreen
    else if (isLoggedIn)
        return SlidingMenu
    return LoginScreen
}

