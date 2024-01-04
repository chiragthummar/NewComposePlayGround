package com.md.newcomposeplayground.stackoverflowq

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun Stack02() {

    val text1 = remember { mutableStateOf(TextFieldValue("")) }
    val text2 = remember { mutableStateOf(TextFieldValue("")) }

    Column() {
        TextField(
            value = text1.value,
            onValueChange = {
                text1.value = it
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = {
                    Log.d("Screen", "NEXT")
                }
            )
        )
        TextField(
            value = text2.value,
            onValueChange = {
                text2.value = it
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    Log.d("Screen", "DONE")
                }
            )
        )
    }
}