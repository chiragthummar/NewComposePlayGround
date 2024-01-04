package com.md.newcomposeplayground.sharedflowexample

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext


@Composable
fun SharedFlowExampleScreen(sharedShareFlowExampleViewModel: ShareFlowExampleViewModel) {

    val context = LocalContext.current

    LaunchedEffect(true) {
        sharedShareFlowExampleViewModel.showToast.collect { show ->
            if (show) {
                Toast.makeText(context, "Toast Show", Toast.LENGTH_SHORT).show()
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { sharedShareFlowExampleViewModel.showToastMessage() }) {
            Text(text = "Show Message")
        }
    }
}