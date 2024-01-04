package com.md.newcomposeplayground.sharedflowexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class ShareFlowExampleViewModel : ViewModel() {
    private val _showToast = MutableSharedFlow<Boolean>()
    val showToast = _showToast.asSharedFlow()

    fun showToastMessage() {
        viewModelScope.launch {
            _showToast.emit(true)
        }
    }
}