package com.example.sori_records_grupo01tk.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sori_records_grupo01tk.viewmodel.LoginViewModel

@Composable
fun MyComposable(viewModel: LoginViewModel = viewModel()) {
    val booleanValue = viewModel.booleanValue.collectAsState()

    Column {
        BasicText("Boolean Value: ${booleanValue.value}")

        Button(onClick = {
            // Toggle the boolean value and save it
            viewModel.saveBoolean(!booleanValue.value)
        }) {
            BasicText("Toggle Value")
        }
    }
}
