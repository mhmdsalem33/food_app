package com.salem.foodapp.data.extentions

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.sa.cap.data.core.ResponseState
import com.tharawat.plus10v1.core.BaseResponse
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.SerializationException
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.File
import java.io.IOException


//fun File.createMultiPartImage(key: String): MultipartBody.Part? {
//    return if (this.exists())
//        MultipartBody.Part.createFormData(key, this.name, this.createRequestBodyImage())
//    else
//        null
//}
//
//fun File.createRequestBodyImage(): RequestBody {
//    return this.asRequestBody("image/*".toMediaTypeOrNull())
//}

fun File.createMultiPartImage(key: String): MultipartBody.Part? {
    return if (this.exists()) {
        val mediaType = this.asRequestBody("*/*".toMediaTypeOrNull())
        MultipartBody.Part.createFormData(key, this.name, mediaType)
    } else {
        null
    }
}

fun File.createMultiPart(
    key: String,
    mediaType: String = "application/octet-stream"
): MultipartBody.Part? {
    return if (this.exists()) {
        val requestBody = this.asRequestBody(mediaType.toMediaTypeOrNull())
        MultipartBody.Part.createFormData(key, this.name, requestBody)
    } else {
        null
    }
}


fun File.createMultiPartAudio(key: String): MultipartBody.Part? {
    return if (this.exists()) {
        val mediaType = "audio/*".toMediaTypeOrNull()
        val requestBody = this.asRequestBody(mediaType)
        MultipartBody.Part.createFormData(key, this.name, requestBody)
    } else {
        null
    }
}

fun String?.createRequestBody(): RequestBody? {
    return this?.toRequestBody("text/plain".toMediaTypeOrNull())
}


fun convertToMap(requestBody: MultipartBody): Map<String, RequestBody> {
    val params = mutableMapOf<String, RequestBody>()
    requestBody.parts.forEach { part ->
        params[part.headers?.get("Content-Disposition")
            ?.replace("form-data; name=\"", "")?.replace("\"", "")
            ?: ""] = part.body
    }
    return params
}

suspend fun <T : Any> safeApiCall(apiCall: suspend () -> Response<T>): ResponseState<T> {
    return try {
        val apiResponse = apiCall.invoke()
        if (apiResponse.isSuccessful) {
            Log.e("testApp" , "api call is success")
            apiResponse.body()?.let {
                ResponseState.Success(it)
            } ?: ResponseState.NullData()
        } else if (apiResponse.code() == 401) {
            ResponseState.Unauthorized()
        } else {
            Log.e("testApp" , "api call is not  success")

            val error = apiResponse.errorBody()?.parseErrorBody<BaseResponse>()
            val errorMessage = error?.message ?: "Unknown error"
            ResponseState.Error(errorMessage)
        }
    } catch (e: IOException) {
        ResponseState.Error(e.message ?: "Network error")
    } catch (e: Exception) {
        ResponseState.Error(e.message ?: "Unknown error")
    }
}

suspend fun <T : Any, R : Any> safeApiCall(
    apiCall: suspend () -> Response<T>,
    mapper: (T) -> R
): ResponseState<R> {
    return try {
        val apiResponse = apiCall.invoke()
        if (apiResponse.isSuccessful) {
            apiResponse.body()?.let {
                ResponseState.Success(mapper(it))
            } ?: ResponseState.NullData()
        } else {
            ResponseState.Error("something went wrong ${apiResponse.message()}")
        }
    } catch (e: IOException) {
        ResponseState.Error(e.message ?: "Network error")
    } catch (e: Exception) {
        ResponseState.Error(e.message ?: "Unknown error")
    }
}


// For Ktor's HttpResponse
suspend inline fun <reified T> safeApiCallForKtor(apiCall: () -> HttpResponse): ResponseState<T> {
    return try {
        val response = apiCall.invoke()
        when (response.status.value) {
            401 -> {
                ResponseState.Unauthorized()
            }
            in 200..299 -> {
                // Successful response
                ResponseState.Success(response.body())
            }
            in 400..499 -> {
                // Handle other client errors
                ResponseState.Error("Client Error: ${response.status.value}, Message: ${response.bodyAsText()}")
            }
            in 500..599 -> {
                // Handle server errors
                ResponseState.Error("Server Error: ${response.status.value}, Message: ${response.bodyAsText()}")
            }
            else -> {
                // Handle unexpected status codes
                ResponseState.Error("Unexpected Error: ${response.status.value}, Message: ${response.bodyAsText()}")
            }
        }
    } catch (e: Exception) {
        // Handle exceptions
        ResponseState.Error("Check internet connection")
    }
}


// For Retrofit's Response<T>
suspend fun <T : Any> safeApiCallForRetrofit(apiCall: suspend () -> Response<T>): ResponseState<T> {
    return try {
        val response = apiCall.invoke()
        if (response.isSuccessful) {
            ResponseState.Success(response.body()!!)
        } else {
            ResponseState.Error("HTTP Error: ${response.code()}, Message: ${response.message()}")
        }
    } catch (e: Exception) {
        ResponseState.Error("Exception: ${e.message}")
    }
}


//suspend inline fun <reified T> safeApiCall(apiCall: () -> HttpResponse): ResponseState<T> {
//    return try {
//        // Execute the API call
//        val response = apiCall.invoke()
//        val responseBody = response.bodyAsText()
//
//        // Handle response based on HTTP status code
//        when (response.status.value) {
//            in 200..299 -> {
//                // Deserialize the response body to the expected type
//                val body: T = response.body()
//                ResponseState.Success(body)
//            }
//            in 400..499 -> {
//                // Handle client-side errors (e.g., 401 Unauthorized)
//                if (response.status.value == 401) {
//                    ResponseState.Unauthorized()
//                } else {
//                    ResponseState.Error("Client Error: ${response.status.value}, Message: $responseBody")
//                }
//            }
//            in 500..599 -> {
//                // Handle server-side errors
//                ResponseState.Error("Server Error: ${response.status.value}, Message: $responseBody")
//            }
//            else -> {
//                // Handle unexpected HTTP status codes
//                ResponseState.Error("Unexpected Error: ${response.status.value}, Message: $responseBody")
//            }
//        }
//    } catch (e: IOException) {
//        // Handle network connectivity issues
//        ResponseState.InternetConnectionError()
//    } catch (e: SerializationException) {
//        // Handle JSON deserialization issues
//        ResponseState.Error("Serialization Error: ${e.message}")
//    } catch (e: Exception) {
//        // Handle other unexpected exceptions
//        ResponseState.Error("Unknown Error: ${e.message}")
//    }
//}


suspend fun <T> safeApiCallSuspend(apiCall: suspend () -> T): ResponseState<T> {
    return try {
        val response = apiCall.invoke()
        ResponseState.Success(response)
    } catch (e: IOException) {
        ResponseState.InternetConnectionError()
    } catch (e: Exception) {
        ResponseState.Error(e.message ?: "Unknown error")
    }
}

suspend fun <T, R> safeApiCallWithMapping(
    apiCall: suspend () -> T,
    mapper: (T) -> R
): ResponseState<R> {
    return try {
        val response = apiCall.invoke()
        ResponseState.Success(mapper(response))
    } catch (e: IOException) {
        ResponseState.InternetConnectionError()
    } catch (e: Exception) {
        ResponseState.Error(e.message ?: "Unknown error")
    }
}
inline fun <reified T> ResponseBody?.parseErrorBody(): T? {
    return try {
        val errorResponseString = this?.string() ?: return null
        Gson().fromJson(errorResponseString, T::class.java)
    } catch (e: JsonParseException) {
        null
    }
}


