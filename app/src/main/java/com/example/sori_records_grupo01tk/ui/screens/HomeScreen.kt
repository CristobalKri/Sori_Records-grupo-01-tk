package com.example.sori_records_grupo01tk.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.times
import androidx.navigation.NavController
import com.example.sori_records_grupo01tk.R
import com.example.sori_records_grupo01tk.datos.AlbumsList
import com.example.sori_records_grupo01tk.ui.utils.AlbumsHomeUtils
import com.example.sori_records_grupo01tk.model.Album
import com.example.sori_records_grupo01tk.ui.components.AlbumCard
import com.example.sori_records_grupo01tk.ui.components.CaruselCard
import com.example.sori_records_grupo01tk.ui.components.Footer


val randomAlbums = AlbumsHomeUtils.randomAlbums(5)
val lastVinilos = AlbumsHomeUtils.lastPorTipo("Vinilo", 3)
val baratos = AlbumsHomeUtils.porPrecio(20000)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
) {


    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item(span = { GridItemSpan(maxLineSpan) }) {
            Text(text = "Bienvenido!", style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { navController.navigate("registro") }) {
                Text("Futura Search bar")
            }
            Spacer(modifier = Modifier.height(16.dp))

            CaruselCard()
            Spacer(modifier = Modifier.height(16.dp))
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            Text("Random", style = MaterialTheme.typography.titleMedium)
        }
        items(randomAlbums) { album ->
            AlbumCard(album) }

        item(span = { GridItemSpan(maxLineSpan) }) {
            Text("Ofertas", style = MaterialTheme.typography.titleMedium)
        }
        items(baratos) { album ->
            AlbumCard(album) }

        item(span = { GridItemSpan(maxLineSpan) }) {
            Text("Últimos Vinilos", style = MaterialTheme.typography.titleMedium)
        }
        items(lastVinilos) { album ->
            AlbumCard(album) }

        item(span = { GridItemSpan(maxLineSpan) }) {
            Spacer(modifier = Modifier.height(16.dp))
            Footer()
        }
    }
}
