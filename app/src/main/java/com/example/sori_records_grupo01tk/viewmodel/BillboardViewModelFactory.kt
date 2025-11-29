package com.example.sori_records_grupo01tk.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sori_records_grupo01tk.datos.BillboardRepository

class BillboardViewModelFactory(
    private val repo: BillboardRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BillboardViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BillboardViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}