package com.md.newcomposeplayground.stackoverflowq

//https://stackoverflow.com/questions/77736830/why-is-jetpack-compose-using-the-old-state-in-the-ontap-event

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun TopLevelComposable(modifier: Modifier = Modifier) {

    var number by rememberSaveable { mutableIntStateOf(0) }

    Column (modifier = Modifier.fillMaxSize()){
        TestCanvasComposable(number)
        Button(onClick = {

            number += 1

        }) {
            Text(
                text = "Increase",
                modifier = modifier
            )
        }
    }
}

@Composable
fun TestCanvasComposable(
    number: Int,
    modifier: Modifier = Modifier
) {
    val num by rememberUpdatedState(newValue = number)
    val textMeasurer = rememberTextMeasurer()
    Canvas(modifier = modifier
        .fillMaxWidth()
        .height(30.dp)
        .pointerInput(Unit) {
            detectTapGestures(
                onTap = {
                    // This does not show the correct number:
                    Log.i("Test", "The number is $num")
                }
            )
        }, onDraw = {
        drawRect(Color.Yellow, Offset.Zero, this.size)

        drawText(
            textMeasurer = textMeasurer,
            text = buildAnnotatedString {
                withStyle(ParagraphStyle(textAlign = TextAlign.Start)) {
                    // This works perfectly:
                    append("The number is: $num")
                }
            }
        )
    }
    )
}