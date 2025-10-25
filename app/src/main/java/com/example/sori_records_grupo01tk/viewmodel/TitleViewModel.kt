package com.example.sori_records_grupo01tk.viewmodel
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State

class TitleViewModel : ViewModel() {
    private val _currentScreenTitle = mutableStateOf("Sori Records")
    val currentScreenTitle: State<String> = _currentScreenTitle

    fun updateScreenTitle(newTitle: String) {
        _currentScreenTitle.value = newTitle
    }
}