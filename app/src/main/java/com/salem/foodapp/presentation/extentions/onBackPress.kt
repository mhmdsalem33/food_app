package com.salem.foodapp.presentation.extentions

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect

fun OnBackPressedDispatcher.addCallback(
    enabled: Boolean = true,
    onBackPressed: () -> Unit = {}
): OnBackPressedCallback {
    val callback = object : OnBackPressedCallback(enabled) {
        override fun handleOnBackPressed() {
            onBackPressed()
        }
    }
    addCallback(callback)
    return callback
}



@Composable
fun BackHandler(
    onBackPressed: () -> Unit
) {
    val dispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    DisposableEffect(dispatcher) {
        val callback = dispatcher?.addCallback { onBackPressed() }
        onDispose {
            callback?.remove()
        }
    }
}
