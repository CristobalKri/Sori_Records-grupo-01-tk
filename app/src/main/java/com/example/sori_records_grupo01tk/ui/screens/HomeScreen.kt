package com.example.sori_records_grupo01tk.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.example.sori_records_grupo01tk.R
import com.example.sori_records_grupo01tk.model.Album
import com.example.sori_records_grupo01tk.ui.components.AlbumCard
import com.example.sori_records_grupo01tk.ui.components.CaruselCard
import com.example.sori_records_grupo01tk.ui.components.Footer


val Albums = listOf(
    Album(1, "holi", "holi2", R.drawable.logo, 15990, "blablbalbalbla"),
    Album(2,"holi3","holi4",R.drawable.logo, 15990,  "blablbalbalbla"),
    Album(3,"holifd","holi4",R.drawable.logo, 15990,  "blablbalbalbla"),
    Album(4,"holisdf","holi4",R.drawable.logo, 15990,  "blablbalbalbla"),
    Album(5,"holisdf","holi4",R.drawable.logo, 15990,  "blablbalbalbla"),
    Album(6,"holisdf","holi4",R.drawable.logo, 15990,  "blablbalbalbla"),
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Sori Records",
                fontWeight = FontWeight.Bold) }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)

        ) {
            item {
                Text(text = "Bienvenido!")
                Button(
                    onClick = { /* acción futura */ },
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text("Futura Search bar")
                }
            }

            item {
                CaruselCard()
            }

            item {
                Box(modifier = Modifier
                    .fillMaxWidth() ){
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(minSize = 150.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier
                            .fillMaxSize()
                            .height((Albums.size / 2 + 1) * 130.dp)

                    )
                    {
                        items(Albums) { album ->
                            AlbumCard(album)
                        }
                    }
                }
            }

            item {
                Footer()
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}