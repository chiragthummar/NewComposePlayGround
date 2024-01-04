package com.md.newcomposeplayground.stackoverflowq

sealed class StoveFormEvent {
data class TurnStoveChange(val turn: Boolean): StoveFormEvent()
data class FakeApiCall(val turn: Boolean): StoveFormEvent()
}