package com.md.newcomposeplayground.stackoverflowq

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

//https://stackoverflow.com/questions/77630739/simple-three-by-three-grid-in-jetpack-compose?noredirect=1#comment136859613_77630739

@Composable
fun Stack06() {
   /*LazyColumn {
       items(gameState.value){item ->
           Row {
               item.toList().forEachIndexed { i, item ->
                   Column {
                       Button(
                           onClick = {},
                           modifier =
                           Modifier.align(Alignment.CenterHorizontally)
                               .padding(8.dp)
                               .background(Color.Red)
                       ) {
                           Text("$col:$i")
                       }
                   }
               }
           }
       }
   }*/
}

//@Composable
//fun chatList(messageList: MutableList<ChatMessage>, modifier: Modifier){
    /*Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize().weight(1f)){
            items(messageList){
                DialogBox(text = it.text, type = it.type)
            }
        }
        TextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(text = "Send a chat")
            },
            shape = CircleShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFFEEEEEE),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }*/
//}

