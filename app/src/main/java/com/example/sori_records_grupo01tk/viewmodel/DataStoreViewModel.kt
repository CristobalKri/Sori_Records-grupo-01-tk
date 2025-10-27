package com.example.sori_records_grupo01tk.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.sori_records_grupo01tk.datos.getBooleanValue
import com.example.sori_records_grupo01tk.datos.saveBooleanValue
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val _booleanValue = MutableStateFlow(false)
    val booleanValue: StateFlow<Boolean> = _booleanValue

    init {
        // Load the boolean value from DataStore
        viewModelScope.launch {
            getBooleanValue(application).collect { value ->
                _booleanValue.value = value
            }
        }
    }

    // Function to save boolean value
    fun saveBoolean(value: Boolean) {
        viewModelScope.launch {
            saveBooleanValue(getApplication(), value)
        }
    }
}
