package com.example.sori_records_grupo01tk.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.sori_records_grupo01tk.datos.getBooleanValue
import com.example.sori_records_grupo01tk.datos.getIntValue
import com.example.sori_records_grupo01tk.datos.saveBooleanValue
import com.example.sori_records_grupo01tk.datos.saveIntValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val _booleanValue = MutableStateFlow(false)
    val booleanValue: StateFlow<Boolean> = _booleanValue

    private val _numeroValue = MutableStateFlow(0)
    val numeroValue: StateFlow<Int> = _numeroValue


    init {
        // Load the boolean value from DataStore
        viewModelScope.launch {
            getBooleanValue(application).collect { value ->
                _booleanValue.value = value
            }
        }

        viewModelScope.launch {
            getIntValue(application).collect { value: Int ->
                _numeroValue.value = value
            }
        }

    }

    fun saveBoolean(value: Boolean) {
        viewModelScope.launch {
            saveBooleanValue(getApplication(), value)
        }
    }

    fun saveInt(value: Int?) {
        viewModelScope.launch {
            saveIntValue(getApplication(), value ?: 0)
        }
    }

}
