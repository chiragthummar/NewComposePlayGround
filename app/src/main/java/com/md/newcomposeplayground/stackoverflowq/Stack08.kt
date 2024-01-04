package com.md.newcomposeplayground.stackoverflowq

//https://stackoverflow.com/questions/77660868/update-my-state-but-cant-update-my-ui-in-jetpack-compose

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.md.newcomposeplayground.stackoverflowq.viewmodels.Stack08ViewModel

@Composable
fun Stack08(stack08ViewModel: Stack08ViewModel) {
    val viewModel = viewModel<Stack08ViewModel>()
    val state = viewModel.state.collectAsState().value

    Column {
        Button(onClick = { stack08ViewModel.onEvent(StoveFormEvent.FakeApiCall(!state.turn)) }) {
            Text(text = "Fake Api Call")
        }
        StoveCard(value = state.turn) {
            stack08ViewModel.onEvent(StoveFormEvent.TurnStoveChange(!state.turn))
        }
    }
}

@Composable
fun StoveCard(value: Boolean, onValueChange: (Boolean) -> Unit) {
    Column {
        Switch(
            checked = value,
            onCheckedChange = onValueChange,
        )
    }
}