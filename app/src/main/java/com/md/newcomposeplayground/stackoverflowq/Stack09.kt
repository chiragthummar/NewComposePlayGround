package com.md.newcomposeplayground.stackoverflowq

//https://stackoverflow.com/questions/77697972/how-to-make-rectangle-background-that-cut-from-right-side-like-tilt-in-jetpack-c/77698259#77698259

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Stack09(modifier: Modifier = Modifier) {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Magenta)
    ) {

        Box(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .height(50.dp)
                .drawBehind {
                    val trianglePath = Path().apply {
                        moveTo(0f, 0f)
                        lineTo(x = size.width, y = 0f)
                        lineTo(x = size.width - 50f, y = size.height)
                        lineTo(x = 0f, y = size.height)
                    }

                    drawPath(
                        color = Color.Red,
                        path = trianglePath,
                        blendMode = BlendMode.DstOut
                    )

                    clipPath(trianglePath) {
                        drawRect(
                            color = Color.White,
                        )
                    }
                },
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "4 Core Carvers Routine",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}