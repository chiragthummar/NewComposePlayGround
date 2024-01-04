package com.md.newcomposeplayground.alertdialogexample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun AlertDialogExample() {

    val showDialog = remember { mutableStateOf(false) }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showDialog.value = false
            },
            title = {
                Text(
                    text = "Alert dialog sample code",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            },
            text = {
                Text(
                    "Do you want to move forward?",
                    fontSize = 16.sp
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog.value = false
                    }) {
                    Text("Yes", style = TextStyle(color = Color.Black))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDialog.value = false
                    }) {
                    Text("No", style = TextStyle(color = Color.Black))
                }
            },
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { showDialog.value = true }) {
            Text(text = "Show Dialog")
        }
    }
}