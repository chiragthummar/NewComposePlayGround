package com.md.newcomposeplayground.stackoverflowq

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.md.newcomposeplayground.R

//https://stackoverflow.com/questions/77611507/partially-collapsing-image-on-top-of-the-screen-in-jetpack-compose

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Stack04() {

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                title = {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.fox),
                        contentDescription = "Fox"
                    )
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(200) { item ->
                Text(text = "Item $item")
            }
        }
    }

}