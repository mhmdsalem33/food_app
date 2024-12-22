package com.salem.foodapp.domain.usecases.auth

import com.salem.foodapp.data.models.auth.login.LoginRequest
import com.salem.foodapp.domain.repo.auth.LoginRepository

class LoginUseCase(private val loginRepository: LoginRepository) {
    suspend operator fun invoke(loginRequest: LoginRequest) = loginRepository.login(loginRequest)
}