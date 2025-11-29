package com.example.sori_records_grupo01tk.datos

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "settings")

val IS_LOGGED_IN = booleanPreferencesKey("isLoggedIn")

private val ID_KEY = intPreferencesKey(name = "numero_key")

fun getBooleanValue(context: Context): Flow<Boolean> {
    return context.dataStore.data
        .map { preferences ->
            preferences[IS_LOGGED_IN] ?: false
        }
}

suspend fun saveBooleanValue(context: Context, value: Boolean) {
    context.dataStore.edit { preferences ->
        preferences[IS_LOGGED_IN] = value
    }
}

fun getIntValue(context: Context): Flow<Int> {
    return context.dataStore.data
        .map { preferences ->
            preferences[ID_KEY] ?: 0
        }
}

suspend fun saveIntValue(context: Context, value: Int) {
    context.dataStore.edit { preferences ->
        preferences[ID_KEY] = value
    }
}