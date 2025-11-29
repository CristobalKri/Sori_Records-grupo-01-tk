package com.example.sori_records_grupo01tk.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.example.sori_records_grupo01tk.viewmodel.AlbumViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UseScreen(albumViewModel: AlbumViewModel) {


    LaunchedEffect(Unit) {
        albumViewModel.fetchAlbums()
    }

    val albumList = albumViewModel.albumList.collectAsState().value

    LazyColumn {
        items(albumList) { album ->
            Text("id: ${album.id}, Name: ${album.title}, artista: ${album.artista}, Descripcion: ${album.descri}")
        }
    }
}
