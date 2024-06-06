package com.salem.foodapp.presentation.ui.activity.screens.auth.onboarding

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.salem.foodapp.R
import com.salem.foodapp.presentation.navigation.LoginScreen
import com.salem.foodapp.presentation.ui.theme.ChangeStatusBarColorAndNavigationBar
import com.salem.foodapp.presentation.widgets.buttons.OrangeCircleButton
import kotlinx.coroutines.launch


@Composable
fun OnboardingScreen(  navController: NavController? = null   ,  onBoardingViewModel: OnBoardingViewModel ? = null ) {


    ChangeStatusBarColorAndNavigationBar(
        isStatusBarIconColorDark = true,
        isNavigationBarIconColorDark = true,
        isContentTopTransparent = true,
    )

    val pages = listOf(
        OnboardingModel.FirstPage, OnboardingModel.SecondPage, OnboardingModel.ThirdPages
    )
    val pagerState = rememberPagerState(initialPage = 0) { pages.size }

    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier
            .fillMaxSize().background(Color.White)
            ,
        containerColor = Color.White,
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = with(LocalDensity.current) { 40.dp })
                ,
                contentAlignment = Alignment.Center
            ) {
                OrangeCircleButton(
                    onButtonClick = {
                        scope.launch {
                            if (pagerState.currentPage < pages.size - 1) {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            } else {
//                                onBoardingViewModel?.setOnboardingCompleted()
                                navController?.navigate(LoginScreen)
                            }
                        }
                    }
                )
            }
        },
        content = { innerPadding ->

            Column(Modifier.padding(innerPadding)) {
                HorizontalPager(state = pagerState) { index ->
                    OnboardingGraphUI(onboardingModel = pages[index] , pages.size, index)
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen()
}