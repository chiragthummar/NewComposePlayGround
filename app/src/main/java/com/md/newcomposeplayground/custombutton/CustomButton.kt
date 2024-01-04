package com.md.newcomposeplayground.custombutton

//https://stackoverflow.com/questions/77596575/how-can-i-get-this-overlay-effect-in-jetpack-compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun CustomButtonExample() {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        val si = size.copy(height = size.height - 15)
        drawRoundRect(
            cornerRadius = CornerRadius(35f, 35f),
            color = Color(0xFFA7A4F8),
            size = size
        )
        drawRoundRect(
            cornerRadius = CornerRadius(35f, 35f),
            color = Color(0xFF8976EA),
            size = si
        )
    }

}