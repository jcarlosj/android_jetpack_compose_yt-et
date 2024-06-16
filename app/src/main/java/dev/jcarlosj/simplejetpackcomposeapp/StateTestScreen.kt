package dev.jcarlosj.simplejetpackcomposeapp

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun StateTestScreen( viewModel: StateTestViewModel ) {
    Log.i("MyScreenLog", "is called" );

    /** Recordara el estado de la valiable aun cuando el dispositivo se rota
     * remember -> persist even on recomposition
     * rememberSaveable -> persist even on configuration changes
     * */
    val name by viewModel.name.observeAsState(
        initial = ""
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyText( name )
        MyTextField( name, onNameChange = {
            viewModel.onNameUpdate( it )
        } )
    }
}

@Composable
fun MyText( name: String ) {
    Text(text = "Hello $name!", style = TextStyle(
        fontSize = 30.sp
    ))
}

@Composable
fun MyTextField( name: String, onNameChange: (String) -> Unit ) {
    OutlinedTextField(
        value = name,
        onValueChange = {
            onNameChange( it )
        },
        label = {
            Text(text = "Enter name")
        })
}