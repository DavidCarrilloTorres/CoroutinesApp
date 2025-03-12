package com.example.coroutinesapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.coroutinesapp.viewmodel.MainViewModel

@Composable
fun CoroutinesApp(viewModel: MainViewModel, modifier: Modifier = Modifier) {
    var changeColor by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { changeColor = !changeColor },
            colors = ButtonDefaults.buttonColors(if (changeColor) Color.Blue else Color.Magenta)
        ) {
            Text("Cambio de color")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text("Contador 1: ${viewModel.countTime1} [s]")
        Text("Contador 2: ${viewModel.countTime2} [s]")
        Text(viewModel.resultState)
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { viewModel.startCounters() }) {
            Text("Iniciar Contadores")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { viewModel.cancelCounters() }, colors = ButtonDefaults.buttonColors(Color.Red)) {
            Text("Cancelar Contadores")
        }
    }
}
/*
@Preview(showBackground = true)
@Composable
fun CoroutinesApp_Preview(){
    CoroutinesApp()
}*/
