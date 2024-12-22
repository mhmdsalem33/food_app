package com.salem.foodapp.presentation.ui.activity.screens.auth.onboarding

import androidx.lifecycle.ViewModel
import com.salem.foodapp.domain.usecases.onBorading.GetOnboardingCompletedUseCase
import com.salem.foodapp.domain.usecases.onBorading.SetOnboardingCompletedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class OnBoardingViewModel  @Inject constructor(
    private val getOnboardingCompletedUseCase: GetOnboardingCompletedUseCase,
    private val setOnboardingCompletedUseCase: SetOnboardingCompletedUseCase
)  : ViewModel(){


    val  isOnboardingCompleted  = getOnboardingCompletedUseCase()

    fun setOnboardingCompleted() = setOnboardingCompletedUseCase()


}