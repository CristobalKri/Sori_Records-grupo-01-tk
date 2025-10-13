package com.example.sori_records_grupo01tk.ui.screens

import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
// import androidx.compose.material3.rememberTopAppBarState
import com.example.sori_records_grupo01tk.R
import com.example.sori_records_grupo01tk.ui.components.AlbumCard
import com.example.sori_records_grupo01tk.ui.components.CaruselCard
import com.example.sori_records_grupo01tk.ui.theme.Purple40
import com.example.sori_records_grupo01tk.ui.theme.Purple80
import com.example.sori_records_grupo01tk.ui.theme.PurpleGrey40

val colorStops = arrayOf(
    0.0f to Purple80,
    0.2f to Purple40,
    1f to PurpleGrey40
)

data class Album(val id: Int, val title: String, val artista: String, val cover: Int )
val Albums = listOf(
    Album(1,"holi","holi2",R.drawable.logo) ,
    Album(2,"holi3","holi4",R.drawable.logo),
    Album(3,"holifd","holi4",R.drawable.logo),
    Album(4,"holisdf","holi4",R.drawable.logo),
    Album(5,"holisdf","holi4",R.drawable.logo),
    Album(6,"holisdf","holi4",R.drawable.logo),
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Text(text = "Bienvenido!")
            Button(onClick = { /* acción futura */ },
                modifier = Modifier
                    .padding(16.dp)) {
                Text("Futura Search bar")
            }
            CaruselCard()
            LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 150.dp))
            { items(Albums ) { album ->
                AlbumCard(album)
            } }

            Box(modifier = Modifier.fillMaxSize()){
                LazyColumn (modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center){
                    items(1){ index ->
                        Text(text = "© Sori Records - hola",
                            style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.onSurface),
                            textAlign = TextAlign.Center
                            , modifier = Modifier.padding(20.dp))

                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
