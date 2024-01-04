package com.md.newcomposeplayground.stackoverflowq.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class Stack07ViewModel : ViewModel() {

    var textFieldValue by mutableStateOf("")
        private set

    fun updateTextField(str: String) {
        textFieldValue = str
    }
}