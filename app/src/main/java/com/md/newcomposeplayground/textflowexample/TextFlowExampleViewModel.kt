package com.md.newcomposeplayground.textflowexample

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class TextFlowExampleViewModel : ViewModel() {

    val list = mutableStateListOf("")

    fun addText(item : String){
        list.add(item)
    }

}