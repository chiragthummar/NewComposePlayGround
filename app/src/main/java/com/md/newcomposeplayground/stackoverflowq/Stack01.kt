package com.md.newcomposeplayground.stackoverflowq

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import kotlinx.coroutines.android.awaitFrame


//https://stackoverflow.com/questions/77581954/does-a-launchedeffect-to-request-focus-work-with-animatedvisibility-in-jetpack-c

@Composable
fun Stack01() {
    var isVisible by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }



    Column {
        if (isVisible) {
            Text(
                text = "Text ", modifier = Modifier
                    .focusRequester(focusRequester)
                    .onFocusChanged { focus ->
                        Log.e(TAG, "Stack01: Focus State $focus")
                    }
                    .focusable()
            )
            LaunchedEffect(Unit) {
                awaitFrame()
                focusRequester.requestFocus()
            }
        }

        Button(onClick = { isVisible = true }) {
            Text(text = "Make text appear and focused")
        }
    }
}