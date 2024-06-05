package com.salem.foodapp.domain.usecases

import com.salem.foodapp.data.data_source.local.preferences.shared_preferences.SharedPreferencesManager
import javax.inject.Inject


class GetOnboardingCompletedUseCase @Inject constructor(
    private val sharedPreferencesManager: SharedPreferencesManager
){
    operator fun invoke() = sharedPreferencesManager.isOnboardingCompleted()
}