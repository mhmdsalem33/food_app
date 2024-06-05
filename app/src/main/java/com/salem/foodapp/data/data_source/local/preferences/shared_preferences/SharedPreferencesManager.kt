package com.salem.foodapp.data.data_source.local.preferences.shared_preferences

interface SharedPreferencesManager {
    fun isOnboardingCompleted(): Boolean
    fun setOnboardingCompleted(completed: Boolean)
}