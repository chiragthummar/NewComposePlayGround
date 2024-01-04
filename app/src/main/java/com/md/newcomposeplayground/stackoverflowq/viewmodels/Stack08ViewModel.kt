package com.md.newcomposeplayground.stackoverflowq.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.md.newcomposeplayground.stackoverflowq.StoveFormEvent
import com.md.newcomposeplayground.stackoverflowq.StoveScreenUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class Stack08ViewModel : ViewModel() {
    private val _state = MutableStateFlow(StoveScreenUiState())
    val state = _state.asStateFlow()

    fun onEvent(event: StoveFormEvent) {
        when (event) {
            is StoveFormEvent.TurnStoveChange -> {
                turnStove(event.turn)
            }
            is StoveFormEvent.FakeApiCall -> {
                fakeApiCall()
            }
        }
    }

    private fun fakeApiCall() {
        viewModelScope.launch {
            delay(5000)
            _state.value = state.value.copy(turn = true)
        }
    }

    private fun turnStove(turn: Boolean) {
        _state.value = state.value.copy(turn = turn)
    }
}