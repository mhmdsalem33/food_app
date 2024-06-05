package com.salem.foodapp.presentation.ui.activity.screens.auth.auth_preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.salem.foodapp.presentation.ui.activity.screens.auth.login.LoginScreen
import com.salem.foodapp.presentation.ui.activity.screens.auth.onboarding.OnboardingGraphUI
import com.salem.foodapp.presentation.ui.activity.screens.auth.onboarding.OnboardingModel

@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview1() {
    OnboardingGraphUI(OnboardingModel.FirstPage , 3 , 0)
}

@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview2() {
    OnboardingGraphUI(OnboardingModel.SecondPage  , 3 , 1 )
}

@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview3() {
    OnboardingGraphUI(OnboardingModel.ThirdPages , 3 , 2 )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}