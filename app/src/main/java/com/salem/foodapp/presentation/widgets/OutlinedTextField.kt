package com.salem.foodapp.presentation.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.salem.foodapp.R



@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholderText: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    onImeAction: () -> Unit = {},
    trailingIcon :  @Composable (() -> Unit) = {},
    visualTransformation: VisualTransformation = VisualTransformation.None,

    ) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .border(
                BorderStroke(1.dp, color = colorResource(id = R.color.gray_2)),
                shape = RoundedCornerShape(10.dp)
            ),
        placeholder = {
            TextSofiaPro( text = placeholderText )
        },
        shape = RoundedCornerShape(10.dp),
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.gray_2),
            unfocusedBorderColor = colorResource(id = R.color.gray_2),
            cursorColor = colorResource(id = R.color.gray_1),
            focusedSuffixColor = colorResource(id = R.color.orange),
            unfocusedSuffixColor = colorResource(id = R.color.orange),
            focusedPrefixColor =  colorResource(id = R.color.orange),
            unfocusedPrefixColor =  colorResource(id = R.color.orange),
            unfocusedTrailingIconColor =  colorResource(id = R.color.orange),
            focusedTrailingIconColor =  colorResource(id = R.color.orange),

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
        visualTransformation = visualTransformation
    )
}