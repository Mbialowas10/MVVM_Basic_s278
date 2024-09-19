package com.mbialowas.mvvm_basic_s278

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel() {

    var counter = mutableStateOf(0)
        private set // prevent modification from the outside world

    fun incrementCounter() {
        counter.value += 1
    }

}