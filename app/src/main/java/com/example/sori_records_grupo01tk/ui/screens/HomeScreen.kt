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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.times
import androidx.navigation.NavController
import com.example.sori_records_grupo01tk.R
import com.example.sori_records_grupo01tk.datos.AlbumsList
import com.example.sori_records_grupo01tk.ui.utils.AlbumsHomeUtils
import com.example.sori_records_grupo01tk.model.Album
import com.example.sori_records_grupo01tk.ui.components.AlbumCard
import com.example.sori_records_grupo01tk.ui.components.CaruselCard
import com.example.sori_records_grupo01tk.ui.components.Footer
import com.example.sori_records_grupo01tk.ui.theme.PrimaryColor


val randomAlbums = AlbumsHomeUtils.randomAlbums(5)
val lastVinilos = AlbumsHomeUtils.lastPorTipo("Vinilo", 4)
val lastCDs = AlbumsHomeUtils.lastPorTipo("CD", 4)
val lastCassettes = AlbumsHomeUtils.lastPorTipo("Cassette", 4)
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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
            ) {
                Text(text = "Bienvenid@!",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center
                )
                HorizontalDivider(thickness = 3.dp)

                Button(onClick = { navController.navigate("registro") }) {
                    Text("Futura Search bar")
                }

                CaruselCard()
            }
        }


        //DESTACADOS
        item(span = { GridItemSpan(maxLineSpan) }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HorizontalDivider(
                    thickness = 3.dp,
                    color = PrimaryColor)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Destacados",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
        items(randomAlbums) { album ->
            AlbumCard(album) }


        //OFERTAS
        item(span = { GridItemSpan(maxLineSpan) }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HorizontalDivider(
                    thickness = 3.dp,
                    color = PrimaryColor)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Destacados",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
        items(baratos) { album ->
            AlbumCard(album) }


        //Nuevos Vinilos
        item(span = { GridItemSpan(maxLineSpan) }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HorizontalDivider(
                    thickness = 3.dp,
                    color = PrimaryColor)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Nuevos Vinilos",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
        items(lastVinilos) { album ->
            AlbumCard(album) }

        //Nuevos CDs
        item(span = { GridItemSpan(maxLineSpan) }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HorizontalDivider(
                    thickness = 3.dp,
                    color = PrimaryColor)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Nuevos CDs",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
        items(lastCDs) { album ->
            AlbumCard(album) }

        //Nuevos Cassettes
        item(span = { GridItemSpan(maxLineSpan) }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HorizontalDivider(
                    thickness = 3.dp,
                    color = PrimaryColor)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Nuevos Cassettes",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
        items(lastCassettes) { album ->
            AlbumCard(album) }


        //FOOTER
        item(span = { GridItemSpan(maxLineSpan) }) {
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(
                    thickness = 3.dp,
                    color = PrimaryColor)
            Footer()
        }
    }
}
