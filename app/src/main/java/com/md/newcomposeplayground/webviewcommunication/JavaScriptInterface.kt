package com.md.newcomposeplayground.webviewcommunication

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast

class JavaScriptInterface {

    private val context : Context

    constructor(context : Context){
        this.context = context
    }

    @JavascriptInterface
    fun showToast(str : String){
        Toast.makeText(context, "Message Received From Java Script $str", Toast.LENGTH_SHORT).show()
    }
}