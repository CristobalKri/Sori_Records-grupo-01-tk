package com.example.sori_records_grupo01tk.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.example.sori_records_grupo01tk.datos.AlbumsList.albums
import com.example.sori_records_grupo01tk.ui.components.AlbumCard
import com.example.sori_records_grupo01tk.ui.components.Footer

@Composable
fun Catalogot(tipo:String) {


    val filtrar = albums.filter { it.tipo.equals(tipo) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        if (filtrar.isEmpty()) {
            item {
                HorizontalDivider(thickness = 2.dp)

                Text(
                    "No hay productos disponibles de tipo $tipo",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                HorizontalDivider(thickness = 2.dp)

                Footer()
            }
        } else {
            item {
                HorizontalDivider(thickness = 2.dp)
            }

            item {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 150.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height((filtrar.size / 2 + 1) * 260.dp)
                ) {
                    items(filtrar) { album ->
                        AlbumCard(album)
                    }
                }
            }

            item {
                HorizontalDivider(thickness = 2.dp)
            }

            item {
                Footer()
            }
        }
    }
}