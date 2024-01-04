package com.md.newcomposeplayground

import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.ComponentDialog
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.input.TextFieldValue
import com.md.newcomposeplayground.alertdialogexample.AlertDialogExample
import com.md.newcomposeplayground.autoselectedtextfield.OutLineTextFieldAutoSelected
import com.md.newcomposeplayground.custombutton.CustomButtonExample
import com.md.newcomposeplayground.pendrawingcanvas.DrawingScreen
import com.md.newcomposeplayground.sharedflowexample.ShareFlowExampleViewModel
import com.md.newcomposeplayground.stackoverflowq.Stack01
import com.md.newcomposeplayground.stackoverflowq.Stack011
import com.md.newcomposeplayground.stackoverflowq.Stack012
import com.md.newcomposeplayground.stackoverflowq.Stack02
import com.md.newcomposeplayground.stackoverflowq.Stack04
import com.md.newcomposeplayground.stackoverflowq.Stack05
import com.md.newcomposeplayground.stackoverflowq.Stack07
import com.md.newcomposeplayground.stackoverflowq.Stack08
import com.md.newcomposeplayground.stackoverflowq.TopLevelComposable
import com.md.newcomposeplayground.stackoverflowq.viewmodels.Stack07ViewModel
import com.md.newcomposeplayground.stackoverflowq.viewmodels.Stack08ViewModel
import com.md.newcomposeplayground.textflowexample.TextFlowExampleScreen
import com.md.newcomposeplayground.textflowexample.TextFlowExampleViewModel
import com.md.newcomposeplayground.ui.theme.NewComposePlayGroundTheme
import com.md.newcomposeplayground.webviewcommunication.WebViewCommunication
import com.md.webview.WebViewDemoScree

class MainActivity : ComponentActivity() {

    private val viewModel: ShareFlowExampleViewModel by viewModels()
    private val textFlowExampleViewModel: TextFlowExampleViewModel by viewModels()
    private val stack07ViewModel: Stack07ViewModel by viewModels()
    private val stack08ViewModel: Stack08ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*ComponentDialog(this).apply {
            val contentView = ComposeView(context).apply {
                setContent {
                    //Can pop up normally, but cannot wake up the soft keyboard when TextField gains focus
                    var value by remember { mutableStateOf(TextFieldValue()) }
                    TextField(
                        value = value,
                        onValueChange = {
                            value = it
                        },
                    )
                }
            }
            val layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
            )
            setContentView(contentView, layoutParams)
        }.show()*/

        setContent {
            NewComposePlayGroundTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    SharedFlowExampleScreen(sharedShareFlowExampleViewModel = viewModel)
                    /*TextFlowExampleScreen(
                        textFlowExampleViewModel = textFlowExampleViewModel
                    )*/
//                    AlertDialogExample()
                    //OutLineTextFieldAutoSelected()
//                    CustomButtonExample()
//                    Stack05()
//                    DrawingScreen()
//                    Stack08(
//                        stack08ViewModel = stack08ViewModel
//                    )
                    WebViewCommunication()
                }
            }
        }
    }
}