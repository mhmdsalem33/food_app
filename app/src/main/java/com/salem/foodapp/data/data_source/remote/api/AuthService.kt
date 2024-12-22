package com.salem.foodapp.data.data_source.remote.api

import android.util.Log
import com.salem.foodapp.data.models.auth.login.LoginRequest
import com.salem.foodapp.presentation.common.Constants.baseUrl
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType

class AuthService(private val client: HttpClient) {

    private val loginEndPoint = "auth/login"


    suspend fun login(loginRequest: LoginRequest): HttpResponse {
        val response = client.post("$baseUrl$loginEndPoint") {
            contentType(ContentType.Application.Json)
            setBody(loginRequest)
        }
        Log.e("testKoin", "Response is " + response.body())
        return response
    }




}

