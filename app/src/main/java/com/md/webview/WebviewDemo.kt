package com.md.webview

import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebViewDemoScree() {
    var backEnabled by remember { mutableStateOf(false) }
    var webView: WebView? = null
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            WebView(context).apply {
                webViewClient = object : WebViewClient() {
                    override fun onPageStarted(view: WebView, url: String?, favicon: Bitmap?) {
                        backEnabled = view.canGoBack()
                    }
                }
                settings.javaScriptEnabled = true
                settings.loadWithOverviewMode = true
                settings.userAgentString = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"

                loadUrl("https://v6.mantine.dev/core/modal/")
                webView = this
            }
        }, update = {
            webView = it
        })

    BackHandler(enabled = backEnabled) {
        webView?.goBack()
    }
}