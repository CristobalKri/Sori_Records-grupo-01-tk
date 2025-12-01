package com.example.sori_records_grupo01tk.ui.utils

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sori_records_grupo01tk.datos.AlbumsList
import com.example.sori_records_grupo01tk.model.Album
import com.example.sori_records_grupo01tk.viewmodel.AlbumViewModel
import kotlin.collections.map

object AlbumsHomeUtils {


//
//    fun randomAlbums(cantidad: Int): List<Album> {
//        val albums = AlbumsList.albums
//        return if (cantidad >= albums.size) albums else albums.shuffled().take(cantidad)
//    }
//
//    fun lastPorTipo(tipo: String, cantidad: Int): List<Album> {
//        return AlbumsList.albums
//            .filter { it.tipo.equals(tipo) }
//            .takeLast(cantidad)
//    }
//
//    fun porPrecio(maxPrecio: Int): List<Album> {
//        return AlbumsList.albums.filter { it.precio <= maxPrecio }
//    }
}