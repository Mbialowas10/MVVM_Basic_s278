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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mbialowas.mvvm_basic_s278.ui.theme.MVVM_Basic_s278Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVM_Basic_s278Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Counter(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun Counter(modifier:Modifier = Modifier){
//    var counter = 0
    var counter by rememberSaveable {
        mutableStateOf(99)
    }
    Button(
        modifier = modifier,
        onClick = {
            counter += 1
        }
    ){
        Text(text="This button has been clicked $counter times.")
    }
}