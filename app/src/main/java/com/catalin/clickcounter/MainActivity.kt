package com.catalin.clickcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.catalin.clickcounter.ui.theme.ClickCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClickCounterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    val counter = remember { mutableStateOf(0) }
//                    val onClick = { counter.value += 1 }
//                    var counter by remember { mutableStateOf(0) }
//                    val onClick = { counter += 1 }
                    val (counter, setCounter) = remember { mutableStateOf(0) }
                    val onClick = { setCounter(counter + 1) }
                    ClickCounter(counter.value, onClick)
                }
            }
        }
    }
}

@Composable
fun ClickCounter(count: Int, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = onClick) {
            Text(text = "Button clicked $count times")
        }
    }
}