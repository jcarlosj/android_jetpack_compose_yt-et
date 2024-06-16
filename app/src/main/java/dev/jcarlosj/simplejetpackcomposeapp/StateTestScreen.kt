package dev.jcarlosj.simplejetpackcomposeapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun StateTestScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyText()
        MyTextField()
    }
}

@Composable
fun MyText() {
    Text(text = "Hello!", style = TextStyle(
        fontSize = 30.sp
    ))
}

@Composable
fun MyTextField() {
    var name by remember {
        mutableStateOf( "" )
    }

    OutlinedTextField(
        value = name,
        onValueChange = {
            name = it
        },
        label = {
            Text(text = "Enter name")
        })
}