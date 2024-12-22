package com.salem.foodapp.presentation.widgets.text_fields

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.ScreenSearchDesktop
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.salem.foodapp.R
import com.salem.foodapp.presentation.widgets.texts.TextSofiaPro

@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholderText: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    onImeAction: () -> Unit = {},
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    marginHorizontal: Int = 0
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = marginHorizontal.dp)

            .background(
                color = colorResource(id = R.color.white),
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                BorderStroke(0.5.dp, color = colorResource(id = R.color.gray_2)),
                shape = RoundedCornerShape(10.dp)
            ),

        placeholder = {
            TextSofiaPro(text = placeholderText)
        },
        shape = RoundedCornerShape(10.dp),
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
//            focusedBorderColor = colorResource(id = R.color.gray_2),
//            unfocusedBorderColor = colorResource(id = R.color.gray_2),
            focusedBorderColor = Color.Transparent, // No border when focused
            unfocusedBorderColor = Color.Transparent,
            cursorColor = colorResource(id = R.color.gray_1),
            focusedSuffixColor = colorResource(id = R.color.orange),
            unfocusedSuffixColor = colorResource(id = R.color.orange),
            focusedPrefixColor = colorResource(id = R.color.orange),
            unfocusedPrefixColor = colorResource(id = R.color.orange),
            unfocusedTrailingIconColor = colorResource(id = R.color.orange),
            focusedTrailingIconColor = colorResource(id = R.color.orange),

            ),
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onAny = {
                onImeAction()
            }
        ),
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        leadingIcon = leadingIcon
    )
}


@Composable
@Preview
fun PreviewCustomOutlinedTextField() {
    CustomOutlinedTextField(
        value = "MohamedSalem@yahoo.com",
        onValueChange = {},
        placeholderText = stringResource(id = R.string.your_email_or_phone),
        keyboardType = KeyboardType.Email,
        imeAction = ImeAction.Next,
        trailingIcon = {
        },
        onImeAction = {}
    )
}


@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholderText: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    onImeAction: () -> Unit = {},
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    marginHorizontal: Int = 0
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = marginHorizontal.dp)
//            .background(
//                color = colorResource(id = R.color.white),
//                shape = RoundedCornerShape(10.dp)
//            )
            .background(
                color = colorResource(id = R.color.white),
                shape = RoundedCornerShape(50.dp)
            )
            .border(1.dp, Color(0xFFF2EAEA), RoundedCornerShape(50.dp)),

//            .border(
//                BorderStroke(0.5.dp, color = colorResource(id = R.color.gray_2)),
//                shape = RoundedCornerShape(10.dp)
//            )

        placeholder = {
            TextSofiaPro(text = placeholderText)
        },
        shape = RoundedCornerShape(10.dp),
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
//            focusedBorderColor = colorResource(id = R.color.gray_2),
//            unfocusedBorderColor = colorResource(id = R.color.gray_2),
            focusedBorderColor = Color.Transparent, // No border when focused
            unfocusedBorderColor = Color.Transparent,
            cursorColor = colorResource(id = R.color.gray_1),
            focusedSuffixColor = colorResource(id = R.color.orange),
            unfocusedSuffixColor = colorResource(id = R.color.orange),
            focusedPrefixColor = colorResource(id = R.color.orange),
            unfocusedPrefixColor = colorResource(id = R.color.orange),
            unfocusedTrailingIconColor = colorResource(id = R.color.orange),
            focusedTrailingIconColor = colorResource(id = R.color.orange),

            ),
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onAny = {
                onImeAction()
            }
        ),
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        leadingIcon = leadingIcon
    )
}
