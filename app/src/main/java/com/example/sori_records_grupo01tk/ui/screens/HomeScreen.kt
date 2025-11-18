package com.example.sori_records_grupo01tk.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.sori_records_grupo01tk.ui.utils.AlbumsHomeUtils
import com.example.sori_records_grupo01tk.ui.components.AlbumCard
import com.example.sori_records_grupo01tk.ui.components.CaruselCard
import com.example.sori_records_grupo01tk.ui.components.Footer
import com.example.sori_records_grupo01tk.ui.theme.PrimaryColor
import com.example.sori_records_grupo01tk.viewmodel.CartViewModel


val randomAlbums = AlbumsHomeUtils.randomAlbums(5)
val lastVinilos = AlbumsHomeUtils.lastPorTipo("Vinilo", 4)
val lastCDs = AlbumsHomeUtils.lastPorTipo("CD", 4)
val lastCassettes = AlbumsHomeUtils.lastPorTipo("Cassette", 4)
val baratos = AlbumsHomeUtils.porPrecio(20000)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    cartViewModel: CartViewModel
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

                Button(onClick = {
                    navController.navigate("buscador") {
                        launchSingleTop = true
                        popUpTo("homescreen") {
                            inclusive = false
                        }
                    }
                }) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Buscar",
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Buscar Productos")
                    }
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
            AlbumCard(album, navController=navController, cartViewModel) }


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
            AlbumCard(album,navController=navController, cartViewModel) }


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
            AlbumCard(album,navController=navController, cartViewModel) }

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
            AlbumCard(album,navController=navController, cartViewModel) }

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
            AlbumCard(album,navController=navController, cartViewModel) }


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
