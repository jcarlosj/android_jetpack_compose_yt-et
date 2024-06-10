package dev.jcarlosj.simplejetpackcomposeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /** Define variables con valores mutables */
            var num1 by remember {
                mutableStateOf( "0" )
            }
            var num2 by remember {
                mutableStateOf( "0" )
            }

            /** Basic Calculator */
            Column {
                Text(text = "Basic Calculator")

                /** Obtener los valores de los campos */
                TextField(value = num1, onValueChange = {
                    num1 = it       // Asigna el valor del campo al atributo num1
                })
                TextField(value = num2, onValueChange = {
                    num2 = it       // Asigna el valor del campo al atributo num2
                })

                Row {
                    Button(onClick = {
                        var result = num1.toInt() + num2.toInt()
                        Toast.makeText(applicationContext, "Result is: $result", Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Add")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = {
                        var result = num1.toInt() - num2.toInt()
                        Toast.makeText(applicationContext, "Result is: $result", Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Sub")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = {
                        var result = num1.toInt() * num2.toInt()
                        Toast.makeText(applicationContext, "Result is: $result", Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Mul")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = {
                        var result = num1.toInt() / num2.toInt()
                        Toast.makeText(applicationContext, "Result is: $result", Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Div")
                    }
                }

            }
        }
    }
}