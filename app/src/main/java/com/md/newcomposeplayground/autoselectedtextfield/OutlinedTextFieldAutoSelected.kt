package com.md.newcomposeplayground.autoselectedtextfield

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exp() {
    Scaffold(
        containerColor = Color(33, 17, 52), // Set the overall background color of the Scaffold
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(33, 17, 52),
                    titleContentColor = Color.White,
                ),
                title = {
                    Text(
                        "Shoes Marketplace",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
            )
        },
        modifier = Modifier.fillMaxSize()
    ){
        Column (modifier = Modifier.padding(it)){

        }
    }
}


@Composable
fun OutLineTextFieldAutoSelected() {

    val text = "Default Value"

    val searchTextFieldValue =
        remember { mutableStateOf(TextFieldValue(text)) }

    Column(modifier = Modifier.padding(15.dp)) {
        OutlinedTextField(
            value = searchTextFieldValue.value,
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { state ->
                    if (state.hasFocus) {
                        searchTextFieldValue.value = searchTextFieldValue.value.copy(
                            selection = TextRange(
                                0,
                                searchTextFieldValue.value.text.length
                            )
                        )
                    }
                },
            onValueChange = {
                searchTextFieldValue.value = it
            },
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor = Color.Black,
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
            ),
            placeholder = {
                Text(
                    text = "Enter your text",
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.LightGray
                    )
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                autoCorrect = true,
            ),
        )
    }
}