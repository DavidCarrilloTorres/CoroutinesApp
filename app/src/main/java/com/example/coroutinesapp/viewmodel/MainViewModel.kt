package com.example.coroutinesapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {
    var resultState by mutableStateOf("")
        private set

    var countTime1 by mutableStateOf(0)
        private set

    var countTime2 by mutableStateOf(0)
        private set

    private var job: Job? = null

    fun startCounters() {
        job?.cancel() // Cancelar cualquier ejecución anterior
        job = viewModelScope.launch {
            countTime1 = 0
            countTime2 = 0
            resultState = "Ejecutando..."

            // Contador 1 hasta 5
            for (i in 1..5) {
                delay(1000)
                countTime1 = i
            }
            delay(1000) // Mantener el valor 5 por un segundo

            // Reiniciar y empezar ambos hasta 5
            countTime1 = 0
            countTime2 = 0

            for (i in 1..5) {
                delay(1000)
                countTime1 = i
                countTime2 = i
            }

            resultState = "Proceso finalizado"
        }
    }

    fun cancelCounters() {
        job?.cancel()
        resultState = "Contadores cancelados"
        countTime1 = 0
        countTime2 = 0
    }
}







