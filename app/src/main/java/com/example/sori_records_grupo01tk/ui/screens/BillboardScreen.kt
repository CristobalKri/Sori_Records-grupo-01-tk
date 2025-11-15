package com.example.sori_records_grupo01tk.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sori_records_grupo01tk.viewmodel.BillboardViewModel

@Composable
fun BillboardScreen(viewModel: BillboardViewModel) {
    val songs by viewModel.topSongs.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadTopSongs()
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Top 10 Billboard HOT 100", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))
        if (songs.isEmpty()) {
            Text("Cargando datos...")
        } else {
            songs.forEach {
                Text("${it.rank}. ${it.title} - ${it.artist}")
                Spacer(Modifier.height(8.dp))
            }
        }
    }
}


