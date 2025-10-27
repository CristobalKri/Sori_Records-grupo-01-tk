package com.example.sori_records_grupo01tk.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.sori_records_grupo01tk.datos.EstadoDataStore
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class EstadoViewModel(application: Application) : AndroidViewModel(application) {


    private val estadoDataStore = EstadoDataStore(context = application)

    private val _activo = MutableStateFlow<Boolean?>(value = null)
    val activo: StateFlow<Boolean?> = _activo

    init {
        cargarEstado()
    }

    fun cargarEstado() {
        viewModelScope.launch {
            delay(timeMillis = 500)
            _activo.value = estadoDataStore.obtenerEstado().first() ?: false
        }
    }

    fun alternarEstado() {
        viewModelScope.launch {
            val nuevoValor = !(_activo.value ?: false)

            estadoDataStore.guardarEstado(nuevoValor)

            _activo.value = nuevoValor

            Log.d("Inner check", "Inner State Check: ${activo.value}")

        }
    }

    suspend fun readActivoFromDataStore(): Boolean {
        val preferences = estadoDataStore.obtenerEstado().first()  // Retrieve the state from DataStore
        return preferences ?: false  // Default to 'false' if not found
    }


    }