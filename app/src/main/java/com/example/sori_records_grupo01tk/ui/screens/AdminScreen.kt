package com.example.sori_records_grupo01tk.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sori_records_grupo01tk.ui.components.Footer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminScreen(
    navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier
            .height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextButton(onClick = { navController.navigate("addAlbum/CD") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp) ) {
                    Text("Agregar CD", style = MaterialTheme.typography.bodyLarge, color = Color.Black)
                }

                HorizontalDivider(color = Color.DarkGray, thickness = 1.dp)

                TextButton(onClick = { navController.navigate("addAlbum/Vinilo") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp) ) {
                    Text("Agregar Vinilo", style = MaterialTheme.typography.bodyLarge, color = Color.Black)
                }

                HorizontalDivider(color = Color.DarkGray, thickness = 1.dp)

                TextButton(onClick = { navController.navigate("addAlbum/Cassette") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp) ) {
                    Text("Agregar Cassette", style = MaterialTheme.typography.bodyLarge, color = Color.Black)
                }
            }
        }

        Spacer(modifier = Modifier
            .height(8.dp))

        Footer()
    }
}