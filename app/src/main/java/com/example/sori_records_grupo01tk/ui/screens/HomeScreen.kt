package com.example.sori_records_grupo01tk.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.graphics.Brush
// import androidx.compose.material3.rememberTopAppBarState
import com.example.sori_records_grupo01tk.R
import com.example.sori_records_grupo01tk.ui.theme.Purple40
import com.example.sori_records_grupo01tk.ui.theme.Purple80
import com.example.sori_records_grupo01tk.ui.theme.PurpleGrey40

val colorStops = arrayOf(
    0.0f to Purple80,
    0.2f to Purple40,
    1f to PurpleGrey40
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Sori Records",
                modifier = Modifier
                    .background(Brush.horizontalGradient(colorStops = colorStops))) }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(text = "Bienvenido!")
            Button(onClick = { /* acción futura */ }) {
                Text("Presioname")
            }
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo App",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}