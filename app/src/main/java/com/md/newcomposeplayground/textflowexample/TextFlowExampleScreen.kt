package com.md.newcomposeplayground.textflowexample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun TextFlowExampleScreen(textFlowExampleViewModel: TextFlowExampleViewModel) {

    val textState = remember { mutableStateOf(TextFieldValue("")) }
    val listState = textFlowExampleViewModel.list.toSet()

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            placeholder = { Text("Enter your text") },
            value = textState.value, onValueChange = {
                textState.value = it
            },
            keyboardActions = KeyboardActions(onDone = {
                textFlowExampleViewModel.addText(textState.value.text)
            }),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            trailingIcon = {
                Icon(imageVector = Icons.Filled.Close, contentDescription = "close")
            }
        )
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(listState.toList()) { item ->
                Text(text = item)
            }
        }
    }

}