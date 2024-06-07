package com.salem.foodapp.presentation.widgets.buttons

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.salem.foodapp.R
import com.salem.foodapp.presentation.ui.theme.omnesArabicMedium
import com.salem.foodapp.presentation.ui.effects.NoRippleInteractionSource



@Composable
fun LoadingButton(
    onClick: () -> Unit,
    loading: Boolean = false ,
    error: Boolean = false ,
) {

    val transition = updateTransition(
        targetState = if (error) "error" else if (loading) "loading" else "default",
        label = "master transition",
    )
    val horizontalContentPadding by transition.animateDp(
        transitionSpec = {
            spring(
                stiffness = SpringStiffness,
            )
        },
        targetValueByState = { state -> if (state == "loading") 12.dp else 24.dp },
        label = "button's content padding",
    )

    Button(
        interactionSource = NoRippleInteractionSource(),
        onClick = onClick,
        contentPadding = PaddingValues(
            horizontal = horizontalContentPadding,
            vertical = 8.dp,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.orange),
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 1.dp
        )
    ) {
        Box(contentAlignment = Alignment.Center) {
            LoadingContent(
                loadingStateTransition = transition,
            )
            ErrorContent(
                errorStateTransition = transition,
            )
            PrimaryContent(
                loadingStateTransition = transition,
            )
        }
    }
}

@Composable
private fun LoadingContent(
    loadingStateTransition: Transition<String>,
) {
    loadingStateTransition.AnimatedVisibility(
        visible = { state -> state == "loading" },
        enter = fadeIn(animationSpec = spring(stiffness = SpringStiffness)),
        exit = fadeOut(
            animationSpec = spring(
                stiffness = SpringStiffness,
                visibilityThreshold = 0.10f,
            ),
        ),
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(18.dp),
            color = LocalContentColor.current,
            strokeWidth = 1.5f.dp,
            strokeCap = StrokeCap.Round,
        )
    }
}

@Composable
private fun ErrorContent(
    errorStateTransition: Transition<String>,
) {
    errorStateTransition.AnimatedVisibility(
        visible = { state -> state == "error" },
        enter = fadeIn(animationSpec = spring(stiffness = SpringStiffness)),
        exit = fadeOut(
            animationSpec = spring(
                stiffness = SpringStiffness,
                visibilityThreshold = 0.10f,
            ),
        ),
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription =  "error icon",
            modifier = Modifier.size(18.dp),
            tint = LocalContentColor.current,
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun PrimaryContent(
    loadingStateTransition: Transition<String>,
) {
    loadingStateTransition.AnimatedVisibility(
        visible = { state -> state == "default" },
        enter = fadeIn() + expandHorizontally(
            animationSpec = spring(
                stiffness = SpringStiffness,
                dampingRatio = Spring.DampingRatioMediumBouncy,
                visibilityThreshold = IntSize.VisibilityThreshold,
            ),
            expandFrom = Alignment.CenterHorizontally,
        ),
        exit = fadeOut(
            animationSpec = spring(
                stiffness = SpringStiffness,
                visibilityThreshold = 0.10f,
            ),
        ) + shrinkHorizontally(
            animationSpec = spring(
                stiffness = SpringStiffness,
                visibilityThreshold = IntSize.VisibilityThreshold,
            ),
            shrinkTowards = Alignment.CenterHorizontally,
        ),
    ) {
        Text(
            text = stringResource(id = R.string.login).uppercase(),
            modifier = Modifier.padding(horizontal = 4.dp),
            fontFamily = omnesArabicMedium(),
        )
    }
}

// use same spring stiffness so that all animations finish at about the same time
private val SpringStiffness = Spring.StiffnessMediumLow

@Preview
@Composable
private fun LoadingButtonPreview() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        LoadingButton(
            onClick = {},
            loading = false,
            error = false,
        )
    }
}
