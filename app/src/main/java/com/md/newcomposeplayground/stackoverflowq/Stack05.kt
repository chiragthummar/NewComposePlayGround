package com.md.newcomposeplayground.stackoverflowq

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Stack05() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
            .shadow(5.dp)
            .background(Color(0xFFD88EDD))
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.12f)
                .background(Color(0xFFC27FC6)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "27 DECC",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                modifier = Modifier
                    .rotate(-90f)
                    .background(Color.Red),
            )
        }
    }
}