package com.example.sori_records_grupo01tk.ui.components

import com.example.sori_records_grupo01tk.model.Song

sealed class BillboardUiState {
    object Loading : BillboardUiState()
    data class Success(val songs: List<Song>, val chartDate: String) : BillboardUiState()
    data class Error(val message: String) : BillboardUiState()
}