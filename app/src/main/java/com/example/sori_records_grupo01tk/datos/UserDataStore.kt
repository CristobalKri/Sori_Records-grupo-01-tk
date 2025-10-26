package com.example.sori_records_grupo01tk.datos

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.example.sori_records_grupo01tk.model.Usuario

val Context.dataStore by preferencesDataStore(name = "user_data")

class UserDataStore(context: Context) {

    private val dataStore = context.dataStore

    private val NOMBRE_KEY = stringPreferencesKey("nombre")
    private val CORREO_KEY = stringPreferencesKey("correo")
    private val CLAVE_KEY = stringPreferencesKey("clave")
    private val DIRECCION_KEY = stringPreferencesKey("direccion")


    suspend fun saveUserData(nombre: String, correo: String, clave: String, direccion: String) {
        dataStore.edit { preferences ->
            preferences[NOMBRE_KEY] = nombre
            preferences[CORREO_KEY] = correo
            preferences[CLAVE_KEY] = clave
            preferences[DIRECCION_KEY] = direccion
        }
    }

    fun getName(): Flow<String?> {
        return dataStore.data
            .map { preferences ->
                preferences[NOMBRE_KEY]
            }
    }

    fun getClave(): Flow<String?> {
        return dataStore.data
            .map { preferences ->
                preferences[CLAVE_KEY]
            }
    }

}