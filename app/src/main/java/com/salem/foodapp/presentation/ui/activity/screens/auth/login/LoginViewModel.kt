package com.salem.foodapp.presentation.ui.activity.screens.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sa.cap.data.core.ResponseState
import com.salem.foodapp.data.models.auth.login.LoginRequest
import com.salem.foodapp.data.models.auth.login.LoginResponse
import com.salem.foodapp.domain.usecases.auth.LoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {


    private val _getLoginRemoteResponse = MutableStateFlow<ResponseState<LoginResponse>>(ResponseState.Idle())
    val getLoginRemoteResponse = _getLoginRemoteResponse.asStateFlow()

    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch(Dispatchers.IO){
            loginUseCase(loginRequest).collect{
                _getLoginRemoteResponse.emit(it)
            }
        }
    }
}