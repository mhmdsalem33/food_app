package com.salem.foodapp.presentation.widgets.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salem.foodapp.R
import com.salem.foodapp.presentation.ui.theme.poppinsMedium
import com.salem.foodapp.presentation.widgets.spaces.SpaceWidth15

@Composable
fun SocialMediaLogin(
  textName : String = stringResource(id = R.string.face_book_capital),
  icon : Int   = R.drawable.face_book_icon,
  onClick  : ()  -> Unit = {}
){

    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = Modifier
            .wrapContentWidth()
            .clip(CircleShape)
            .background(colorResource(id = R.color.gray_8))
            .padding(PaddingValues(horizontal = 23.dp, vertical = 15.dp))
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                onClick()
            }
        ,
        verticalAlignment = Alignment.CenterVertically
        )

    {

        Image(
            modifier = Modifier.size(30.dp),
            painter = painterResource(id = icon ),
            contentDescription =  "",

        )
        SpaceWidth15()

        Text(
            text = textName ,
            fontFamily = poppinsMedium(),
            color = colorResource(id = R.color.black),
            fontSize = 12.sp,
        )
    }
}


@Composable
@Preview
fun SocialMediaLoginPreview(){
    SocialMediaLogin()
}