package com.example.sori_records_grupo01tk.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.sori_records_grupo01tk.model.Album
import com.example.sori_records_grupo01tk.repository.AlbumRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AlbumViewModel(application: Application) : AndroidViewModel(application) {

    private val albumRepository = AlbumRepository()
    private val _albumList = MutableStateFlow<List<Album>>(emptyList())
    val albumList: StateFlow<List<Album>> = _albumList

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


}