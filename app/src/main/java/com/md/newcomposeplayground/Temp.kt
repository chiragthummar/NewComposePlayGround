package com.md.newcomposeplayground
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Temp() {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Demo") })
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                items(100) {
                    Text(text = "Temp Itesms")
                }
            }
            OutlinedTextField(
                value = "Sample", onValueChange = {})
        }
    }
}