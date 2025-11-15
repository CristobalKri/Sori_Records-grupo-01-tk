package com.example.sori_records_grupo01tk.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sori_records_grupo01tk.datos.BillboardRepository
import com.example.sori_records_grupo01tk.model.Song
import com.example.sori_records_grupo01tk.ui.utils.FechaBill
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BillboardViewModel(private val repo: BillboardRepository) : ViewModel() {
    private val _topSongs = MutableStateFlow<List<Song>>(emptyList())
    val topSongs: StateFlow<List<Song>> = _topSongs

    private val _chartDate = MutableStateFlow("")
    val chartDate: StateFlow<String> = _chartDate

    fun loadTopSongs() {
        viewModelScope.launch {
            val songs = repo.getTopSongs()
            _topSongs.value = songs

            if (songs.isNotEmpty()) {
                _chartDate.value = FechaBill.getLastSat()
            }
        }
    }
}



