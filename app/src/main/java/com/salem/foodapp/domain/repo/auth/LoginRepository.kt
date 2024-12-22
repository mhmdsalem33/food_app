package com.salem.foodapp.domain.repo.auth

import com.sa.cap.data.core.ResponseState
import com.salem.foodapp.data.models.auth.login.LoginRequest
import com.salem.foodapp.data.models.auth.login.LoginResponse
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun login(loginRequest: LoginRequest) : Flow<ResponseState<LoginResponse>>
}