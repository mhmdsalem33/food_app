package com.salem.foodapp.data.repo.auth

import android.util.Log
import com.sa.cap.data.core.ResponseState
import com.salem.foodapp.data.data_source.remote.api.AuthService
import com.salem.foodapp.data.extentions.safeApiCallForKtor
import com.salem.foodapp.data.models.auth.login.LoginRequest
import com.salem.foodapp.data.models.auth.login.LoginResponse
import com.salem.foodapp.domain.repo.auth.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class LoginRepoImpl(private val apiService: AuthService) : LoginRepository {
    override suspend fun login(loginRequest: LoginRequest): Flow<ResponseState<LoginResponse>> =
        flow {
            try {
                emit(ResponseState.Loading())
                val response = safeApiCallForKtor<LoginResponse> { apiService.login(loginRequest) }
                emit(response)
//                Log.e("testKoin" , response.data.toString())
            } catch (t: Throwable) {
                Log.e("testKoin", "${t.message}")
            }
        }
}