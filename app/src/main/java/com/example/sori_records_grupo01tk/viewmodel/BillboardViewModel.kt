package com.example.sori_records_grupo01tk.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sori_records_grupo01tk.datos.BillboardRepository
import com.example.sori_records_grupo01tk.model.Song
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BillboardViewModel(private val repo: BillboardRepository) : ViewModel() {
    private val _topSongs = MutableStateFlow<List<Song>>(emptyList())
    val topSongs: StateFlow<List<Song>> = _topSongs

    fun loadTopSongs() {
        viewModelScope.launch {
            _topSongs.value = repo.getTopSongs()
        }
    }
}



