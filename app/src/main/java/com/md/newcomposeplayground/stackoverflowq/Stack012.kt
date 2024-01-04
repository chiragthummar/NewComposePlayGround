package com.md.newcomposeplayground.stackoverflowq

import android.content.ContentValues.TAG
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import kotlin.math.abs

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Stack012(modifier: Modifier = Modifier) {


    var showBottomSheet by rememberSaveable { mutableStateOf(false) }
    val state = rememberModalBottomSheetState()

    BackHandler(showBottomSheet) {
        if (showBottomSheet) {
            showBottomSheet = false
        }
    }


    if (showBottomSheet) {
        ModalBottomSheet(
            modifier = Modifier.pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    Log.d(TAG, "Stack012: DFDSFDFS")
                }
                awaitPointerEventScope {
                    while (true) {
                        awaitPointerEvent(pass = PointerEventPass.Initial).changes.forEach {
                            val offset = it.positionChange()
                            if (abs(offset.y) > 0f) {
                                it.consume()
                            }
                        }
                    }
                }
            },
            onDismissRequest = { showBottomSheet = false },
            sheetState = state,
            shape = RoundedCornerShape(size = 12.dp),
            dragHandle = null,
            containerColor = MaterialTheme.colorScheme.errorContainer
        ) {
            Box(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Column(modifier= Modifier.height(350.dp)) {
                    // content
                    // when clicking on a bouton, we launch a coroutine to hide the sheet
                    // and in invokeOnCompletion, we pass showBottomSheet to false
                    Text(text = "BottomSheet Content")
                }
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {
            showBottomSheet = true
        }) {
            Text(text = "Open Dialog")
        }
    }




    /*val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = SheetState(
            initialValue = SheetValue.Hidden,
            confirmValueChange = { it != SheetValue.Hidden },
            skipPartiallyExpanded = true
        )
    )

    *//*BackHandler(scaffoldState.bottomSheetState.isVisible) {
        if(scaffoldState.bottomSheetState.isVisible){
            scope.launch {
                scaffoldState.bottomSheetState.hide()
            }
        }
    }*//*

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 0.dp,
        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(128.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("Swipe up to expand sheet")
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(64.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Sheet content")
                Spacer(Modifier.height(20.dp))
                Button(
                    onClick = {
                        scope.launch { scaffoldState.bottomSheetState.partialExpand() }
                    }
                ) {
                    Text("Click to collapse sheet")
                }
            }
        }) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding), contentAlignment = Alignment.Center) {
            Button(onClick = {
                scope.launch {
                    scaffoldState.bottomSheetState.expand()
                }
            }) {
                Text(text = "Open Dialog")
            }
        }
    }*/




}