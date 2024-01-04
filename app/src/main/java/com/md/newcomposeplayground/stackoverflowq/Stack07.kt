package com.md.newcomposeplayground.stackoverflowq

//https://stackoverflow.com/questions/77663127/jetpack-compose-correct-way-to-let-a-usr-edit-a-text-value-contained-in-a-state

//Ref https://medium.com/androiddevelopers/effective-state-management-for-textfield-in-compose-d6e5b070fbe5

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.md.newcomposeplayground.stackoverflowq.viewmodels.Stack07ViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Stack07(stack07ViewModel: Stack07ViewModel) {

    Scaffold (
        topBar = {
            TopAppBar(title = {
                Text(text = "Text Field Demo")
            },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ))
        }
    ){
        Column (modifier = Modifier
            .padding(it)
            .fillMaxSize()
            .padding(10.dp)){
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = stack07ViewModel.textFieldValue,
                onValueChange = {
                    stack07ViewModel.updateTextField(it)
                },
                placeholder = {
                    Text(text = "Enter your text")
                }
            )
        }
    }
}