package com.mbialowas.mvvm_basic_s278

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


import androidx.compose.ui.Modifier

import androidx.lifecycle.ViewModelProvider
import com.mbialowas.mvvm_basic_s278.ui.theme.MVVM_Basic_s278Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVM_Basic_s278Theme {
                // initialize the viewModel
                val viewModel: AppViewModel = ViewModelProvider(this)[AppViewModel::class.java]

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Counter(modifier = Modifier.padding(innerPadding), viewModel = viewModel)
                }
            }
        }
    }
}


@Composable
fun Counter(viewModel : AppViewModel, modifier:Modifier = Modifier){
//    var counter = 0
    var count by remember {
        viewModel.counter
    }
    Button(
        modifier = modifier,
        onClick = {
            // counter += 1
            viewModel.incrementCounter()
        }
    ){
        Text(text="This button has been clicked $count times.")
    }
}