package com.md.newcomposeplayground.webviewcommunication

import android.webkit.JsPromptResult
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebViewCommunication(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()){
        AndroidView(factory = {context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true

                webChromeClient = object :WebChromeClient() {
                    override fun onJsAlert(
                        view: WebView?,
                        url: String?,
                        message: String?,
                        result: JsResult?
                    ): Boolean {
                        return true
                    }


                    override fun onJsConfirm(
                        view: WebView?,
                        url: String?,
                        message: String?,
                        result: JsResult?
                    ): Boolean {
                        return true
                    }

                    override fun onJsPrompt(
                        view: WebView?,
                        url: String?,
                        message: String?,
                        defaultValue: String?,
                        result: JsPromptResult?
                    ): Boolean {
                        return true
                    }
                }

                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                settings.setSupportZoom(true)

               addJavascriptInterface(JavaScriptInterface(context),"AndroidFunction")

                loadUrl("file:///android_asset/my.html")

            }
        })
    }
}