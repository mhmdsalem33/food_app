package com.salem.foodapp.data.models.auth.login

import kotlinx.serialization.Serializable


@Serializable
data class LoginResponse(
    val id: Int ? = null,
    val username: String ? = null,
    val email: String ? = null,
    val firstName: String ? = null,
    val lastName: String ? = null,
    val gender: String ? = null,
    val image: String ? = null,
    val accessToken: String ? = null,
    val refreshToken: String  ? = null
)