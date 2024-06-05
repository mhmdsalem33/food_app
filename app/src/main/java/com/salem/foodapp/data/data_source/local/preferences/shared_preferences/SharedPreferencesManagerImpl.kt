package com.salem.foodapp.data.data_source.local.preferences.shared_preferences

import android.content.Context
import com.salem.foodapp.presentation.common.Constants.completedKey
import com.salem.foodapp.presentation.common.Constants.onBoardingKey
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPreferencesManagerImpl  @Inject constructor(
    @ApplicationContext private val context: Context
) :SharedPreferencesManager{

    override fun isOnboardingCompleted(): Boolean {
        return context.getSharedPreferences(onBoardingKey, Context.MODE_PRIVATE)
            .getBoolean(completedKey, false)
    }

    override fun setOnboardingCompleted(completed: Boolean) {
        context.getSharedPreferences( onBoardingKey , Context.MODE_PRIVATE)
            .edit()
            .putBoolean(completedKey , completed)
            .apply()
    }

}