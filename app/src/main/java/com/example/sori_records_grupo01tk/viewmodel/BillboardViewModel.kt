package com.example.sori_records_grupo01tk.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sori_records_grupo01tk.datos.BillboardRepository
import com.example.sori_records_grupo01tk.model.Song
import com.example.sori_records_grupo01tk.ui.components.BillboardUiState
import com.example.sori_records_grupo01tk.ui.utils.FechaBill
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BillboardViewModel(private val repo: BillboardRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<BillboardUiState>(BillboardUiState.Loading)
    val uiState: StateFlow<BillboardUiState> = _uiState

    fun loadTopSongs() {
        viewModelScope.launch {
            try {
                val songs = repo.getTopSongs()
                val date = if (songs.isNotEmpty()) FechaBill.getLastSat() else ""
                _uiState.value = BillboardUiState.Success(songs, date)
            } catch (e: Exception) {
                _uiState.value = BillboardUiState.Error("Error al cargar datos")
            }
        }
    }
}



