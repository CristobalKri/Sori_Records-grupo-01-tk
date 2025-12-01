package com.example.sori_records_grupo01tk.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.sori_records_grupo01tk.datos.AlbumsList
import com.example.sori_records_grupo01tk.model.Album
import com.example.sori_records_grupo01tk.model.Usuario
import com.example.sori_records_grupo01tk.repository.AlbumRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AlbumViewModel(application: Application) : AndroidViewModel(application) {

    private val albumRepository = AlbumRepository()
    private val _albumList = MutableStateFlow<List<Album>>(emptyList())
    val albumList: StateFlow<List<Album>> = _albumList

    private val _album = MutableStateFlow<Album?>(null)
    val album: StateFlow<Album?> = _album

    init {
        fetchAlbums()
    }

    fun fetchAlbums() {
        viewModelScope.launch {
            try {
                val response = albumRepository.getAlbums()
                Log.d("API Response", "Response body: ${response.body()}")
                response.body()?.let {
                    Log.d("API Response", it.toString())
                }

                if (response.isSuccessful) {
                    _albumList.value = response.body() ?: emptyList()
                } else {
                    println("Error: ${response.message()}")
                }
            } catch(e: Exception) {
                println("Error al obtener datos: ${e.localizedMessage}")
            }
        }
    }


    fun getAlbumById(id: Int) {
        viewModelScope.launch {
            try {
                val response = albumRepository.getAlbum(id)
                if (response.isSuccessful) {
                    _album.value = response.body()
                    Log.d("API Response", "Album fetched: ${_albumList.value}")
                } else {
                    Log.e("API Error", "Error: ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("API Error", "Error al obtener el album: ${e.localizedMessage}")
            }
        }
    }

    fun updateAlbum(id: Int, album: Album) {
        viewModelScope.launch {
            try {
                val response = albumRepository.updateAlbum(id, album)
                if (response.isSuccessful) {
                    Log.d("API Response", "Album actualizado: ${response.body()}")
                    fetchAlbums()
                } else {
                    Log.e("API Error", "Error: ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("API Error", "Error al actualizar el album: ${e.localizedMessage}")
            }
        }
    }

    fun deleteAlbum(id: Int) {
        viewModelScope.launch {
            try {
                val response = albumRepository.deleteAlbum(id)
                if (response.isSuccessful) {
                    Log.d("API Response", "Album eliminado")
                    fetchAlbums()
                } else {
                    Log.e("API Error", "Error: ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("API Error", "Error al eliminar el album: ${e.localizedMessage}")
            }
        }
    }


    fun randomAlbums(cantidad: Int): List<Album> {
        val albums = albumList.value
        return if (cantidad >= albums.size) albums else albums.shuffled().take(cantidad)
    }

    fun lastPorTipo(tipo: String, cantidad: Int): List<Album> {
        val albums = albumList.value
        return albums
            .filter { it.tipo.equals(tipo) }
            .takeLast(cantidad)
    }

    fun porPrecio(maxPrecio: Int): List<Album> {
        val albums = albumList.value
        return albums.filter { it.precio <= maxPrecio }
    }

}