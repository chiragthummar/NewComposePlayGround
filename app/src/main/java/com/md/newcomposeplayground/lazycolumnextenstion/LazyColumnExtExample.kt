package com.md.newcomposeplayground.lazycolumnextenstion

//https://stackoverflow.com/questions/77596825/how-can-i-extract-items-from-lazycolumn-in-android-jetpack-compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LazyColumnExtExample() {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Example") })
    }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Item1()
            Item2()
        }
    }
}

fun LazyListScope.Item1() {
    item {
        Text(text = "First Item")
    }
}

fun LazyListScope.Item2() {
    item {
        //You can put any  content here
    }
}