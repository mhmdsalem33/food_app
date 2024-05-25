package com.salem.foodapp.presentation.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.salem.foodapp.presentation.theme.FoodAppTheme
import com.salem.foodapp.presentation.ui.activity.screens.auth.onboarding.OnBoardingScreen

class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {

            FoodAppTheme {
//                Scaffold(
//                    modifier = Modifier.fillMaxSize()
//                )
//                { innerPadding ->
//                }
                OnBoardingScreen()




//                OnBoardingScreen()

            }
        }
    }
}



