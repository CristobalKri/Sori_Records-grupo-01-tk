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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.sori_records_grupo01tk.ui.components.AlbumCard
import com.example.sori_records_grupo01tk.ui.components.Footer
import com.example.sori_records_grupo01tk.viewmodel.AlbumViewModel
import com.example.sori_records_grupo01tk.viewmodel.CartViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UseScreen(albumViewModel: AlbumViewModel) {

    val albumViewModel: AlbumViewModel = viewModel()
    val navController: NavController = rememberNavController()
    val cartViewModel: CartViewModel = viewModel()

    val albumList = albumViewModel.albumList.collectAsState().value


    LazyColumn {
        items(albumList) { album ->
            AlbumCard(album, navController, cartViewModel)
        }
    }
}
