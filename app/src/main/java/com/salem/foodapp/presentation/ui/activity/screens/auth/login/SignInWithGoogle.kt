package com.salem.foodapp.presentation.ui.activity.screens.auth.login

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import androidx.credentials.exceptions.GetCredentialException
import androidx.navigation.NavHostController
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import com.salem.foodapp.presentation.navigation.HomeScreen
import org.json.JSONException

const val webClientID = "394883293025-l37pgtng490pee4mb1tvj1vvrrtta8hp.apps.googleusercontent.com"

val SIGNINTAG  = "testSIGNIN"

@Composable
fun SignInWithGoogle(navController: NavHostController?) {

    val context = LocalContext.current

    val credentialManager = CredentialManager.create(context)
    val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
        .setFilterByAuthorizedAccounts(false)
        .setServerClientId(webClientID)
        .setAutoSelectEnabled(true)
        .build()

    val request = GetCredentialRequest.Builder().addCredentialOption(googleIdOption).build()

    LaunchedEffect(Unit) {
        try {
            val result = credentialManager.getCredential(
                request = request,
                context = context,
            )
            handleSignIn(result , navController)
        } catch (e: GetCredentialException) {
            Log.e(SIGNINTAG, e.message ?: "")
        }
    }
}

fun handleSignIn(result: GetCredentialResponse, navController: NavHostController?) {
    try {
        val credential = result.credential

        val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
        val idToken = googleIdTokenCredential.idToken

        // navigate to home screen if sign in is success
        if (idToken.isNotEmpty()){
            navController?.navigate(HomeScreen)
        }

        Log.d(SIGNINTAG  ,  "token id $idToken"  )

    } catch (e: GoogleIdTokenParsingException) {
        Log.e(SIGNINTAG, "Received an invalid google id token response",  e  )
    } catch (e: JSONException) {
        Log.e(SIGNINTAG, "Error parsing ID token", e)
    }
}



