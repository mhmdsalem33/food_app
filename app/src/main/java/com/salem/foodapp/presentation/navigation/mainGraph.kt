package com.salem.foodapp.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.salem.foodapp.presentation.component.SlidingMenu
import com.salem.foodapp.presentation.ui.activity.screens.main.HomeScreen
import kotlinx.serialization.Serializable


fun NavGraphBuilder.mainGraph(
    navController: NavHostController,
) {
    composable<HomeScreen>
    {
        HomeScreen(navController)
    }

    composable<SlidingMenu>
    {
        SlidingMenu()
    }

}

@Serializable
object HomeScreen

@Serializable
object SlidingMenu


