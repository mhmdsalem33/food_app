package com.tharawat.plus10v1.core

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
open class BaseResponse(
    @SerializedName("message")
    val message: String = "",
    @SerializedName("result")
    val result : String = "",
    @SerializedName("code")
    val code : Int = 0,
    @SerializedName("timestamp")
    val timestamp  : String = ""
)
