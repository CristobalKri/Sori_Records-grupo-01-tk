package com.example.sori_records_grupo01tk.datos

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.userPreferenceDataStore by preferencesDataStore(name = "preferencias_usuario")

class EstadoDataStore(private val context: Context) {


    private val ESTADO_ACTIVADO = booleanPreferencesKey(name = "modo_activado")


    suspend fun guardarEstado(valor: Boolean) {
        context.userPreferenceDataStore.edit { preferencias ->
            preferencias[ESTADO_ACTIVADO] = valor
        }
    }


    fun obtenerEstado(): Flow<Boolean?> {
        return context.userPreferenceDataStore.data.map { preferencias ->
            preferencias[ESTADO_ACTIVADO]
        }
    }

}