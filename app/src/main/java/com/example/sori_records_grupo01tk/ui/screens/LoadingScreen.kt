package com.example.sori_records_grupo01tk.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import androidx.compose.ui.platform.testTag // Testing import

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoadingScreen(
    navController: NavController
){
    LaunchedEffect (Unit){
        delay(2500)
        navController.navigate("pagoC"){
            popUpTo("loading") {inclusive = true}
        }
    }
    Box (modifier = Modifier
        .fillMaxSize()
        .testTag("progressIndicator")
        .background(color = MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center){
        Column (horizontalAlignment = Alignment.CenterHorizontally){
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.secondary,
                strokeWidth = 6.dp,
                modifier = Modifier
                    .size(70.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Procesando pago...",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}