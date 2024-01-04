package com.md.newcomposeplayground.stackoverflowq

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//https://stackoverflow.com/questions/77610956/how-to-make-custom-shape-in-jetcompose

@Preview(showBackground = true)
@Composable
fun Stack03() {
    Canvas(modifier = Modifier.size(400.dp)) {
        drawCircle(
            color = Color(0xFFACBCCB),
            radius = 800f,
            center = Offset(size.width / 2.0f, size.height / 5.0f)
        )
        drawCircle(
            color = Color(0xFF0B305E),
            radius = 775f,
            center = Offset(size.width / 2.0f, size.height / 5.0f)
        )
    }
}