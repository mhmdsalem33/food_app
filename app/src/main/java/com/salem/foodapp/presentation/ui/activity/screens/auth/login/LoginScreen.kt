package com.salem.foodapp.presentation.ui.activity.screens.auth.login

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.salem.foodapp.R
import com.salem.foodapp.presentation.extentions.BackHandler
import com.salem.foodapp.presentation.ui.theme.ChangeStatusBarColorAndNavigationBar
import com.salem.foodapp.presentation.ui.theme.poppinsMedium
import com.salem.foodapp.presentation.ui.theme.poppinsSemiBold
import com.salem.foodapp.presentation.widgets.CustomOutlinedTextField
import com.salem.foodapp.presentation.widgets.TextSofiaPro
import com.salem.foodapp.presentation.widgets.buttons.LoadingButton
import com.salem.foodapp.presentation.widgets.buttons.SocialMediaLogin
import com.salem.foodapp.presentation.widgets.spaces.SpaceHeight15
import com.salem.foodapp.presentation.widgets.spaces.SpaceHeight20
import com.salem.foodapp.presentation.widgets.spaces.SpaceHeight30
import com.salem.foodapp.presentation.widgets.spaces.SpaceHeight5
import com.salem.foodapp.presentation.widgets.spaces.SpaceWidth20
import com.salem.foodapp.presentation.widgets.spaces.SpaceWidth5

@Composable
fun LoginScreen(navController: NavHostController? = null) {


    // activity
    val activity = (LocalContext.current as? Activity)

    val keyboardController = LocalSoftwareKeyboardController.current
    val localFocusManager = LocalFocusManager.current
    val rememberScrollState = rememberScrollState()

    val interactionSource = remember { MutableInteractionSource() }




    ChangeStatusBarColorAndNavigationBar(
        isStatusBarIconColorDark = true,
        isNavigationBarIconColorDark = true,
        isContentTopTransparent = true,

        )

    // main box
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState)
            .background(Color.White)
            .imePadding() // for enable scroll when keyboard is opened
    )
    {

        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.ellipse_top_right),
            contentDescription = "top orange image right",
            alignment = Alignment.TopEnd
        )

        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.ellipse_top_left),
            contentDescription = "top orange image left",
            alignment = Alignment.TopStart
        )

        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.ellipse_top),
            contentDescription = "",
            alignment = Alignment.TopStart
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 25.dp, end = 25.dp, top = 120.dp),
//            verticalArrangement = Arrangement.Center
        )
        {
            // text login
            Text(
                text = stringResource(id = R.string.login),
                fontFamily = poppinsSemiBold(),
                fontSize = 35.sp
            )

            SpaceHeight5()


            // text  email
            TextSofiaPro(text = stringResource(id = R.string.email))

            SpaceHeight15()

            // EMAIL  Outline text field
            var email by remember { mutableStateOf("") }

            CustomOutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                placeholderText = stringResource(id = R.string.your_email_or_phone),
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
                trailingIcon = {
                    if (email.isNotEmpty()) {
                        Image(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "clear icon",
                            modifier = Modifier.clickable(
                                interactionSource = interactionSource,
                                indication = null
                            ) { email = "" },
                            colorFilter = ColorFilter.tint(color = colorResource(id = R.color.gray_4))
                        )
                    }
                },
                onImeAction = {
                    localFocusManager.moveFocus(FocusDirection.Down)
                }
            )

            SpaceHeight20()

            // text password
            TextSofiaPro(text = stringResource(id = R.string.password))

            SpaceHeight15()

            var password by remember { mutableStateOf("") }
            var isPasswordVisible by remember { mutableStateOf(false) }

            // outlined password text field
            CustomOutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                placeholderText = stringResource(id = R.string.password),
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
                trailingIcon = {
                    if (password.isNotEmpty()) {
                        val icon =
                            if (isPasswordVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
                        Image(
                            imageVector = icon,
                            contentDescription = if (isPasswordVisible) "hide password" else "show password",
                            modifier = Modifier
                                .clickable(
                                    interactionSource = interactionSource,
                                    indication = null
                                ) {
                                    isPasswordVisible = !isPasswordVisible
                                },
                            colorFilter = ColorFilter.tint(color = colorResource(id = R.color.gray_4))
                        )
                    }

                },
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),

                onImeAction = {
                    keyboardController?.hide()
                    localFocusManager.clearFocus()
                }
            )
            SpaceHeight30()


            Text(
                text = stringResource(id = R.string.forget_password),
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontFamily = poppinsMedium(),
                color = colorResource(id = R.color.orange),
                fontSize = 15.sp
            )

            SpaceHeight30()

            var loadingLoginButtonState by remember { mutableStateOf(false) }


            // Login button
            LoadingButton(
                onClick = { loadingLoginButtonState = true },
                loading = loadingLoginButtonState,
            )

            SpaceHeight30()

            // don't have an account || sign up

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.dont_have_account),
                    fontFamily = poppinsMedium(),
                    color = colorResource(id = R.color.black),
                    fontSize = 15.sp
                )

                SpaceWidth5()

                Text(
                    text = stringResource(id = R.string.sign_up),
                    fontFamily = poppinsMedium(),
                    color = colorResource(id = R.color.orange),
                    fontSize = 15.sp
                )
            }
            SpaceHeight30()

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    modifier = Modifier.weight(1f)
                )

                SpaceWidth20()

                // sign in with
                Text(
                    text = stringResource(id = R.string.sign_in_with),
                    fontFamily = poppinsMedium(),
                    color = colorResource(id = R.color.gray_6),
                    fontSize = 15.sp,
                )
                SpaceWidth20()

                Divider(
                    modifier = Modifier.weight(1f)
                )
            }
            SpaceHeight30()


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                // sign in with facebook
                SocialMediaLogin(
                    textName = stringResource(id = R.string.face_book_capital),
                    icon = R.drawable.face_book_icon,
                    onClick = {
                        Log.e("testApp", "click on facebook")
                    }
                )

                SpaceWidth20()
                // sign in with google

                SocialMediaLogin(
                    textName = stringResource(id = R.string.google_capital),
                    icon = R.drawable.google_icon,
                    onClick = {
                        Log.e("testApp", "click on google")
                    }
                )
            }
            SpaceHeight30()
        }
    }

    // On Back Pressed
    BackHandler(
        onBackPressed = {
            activity?.finish()
        })

}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}