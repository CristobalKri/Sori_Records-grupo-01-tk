package com.example.sori_records_grupo01tk.viewmodel


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.sori_records_grupo01tk.datos.dataStore
import com.example.sori_records_grupo01tk.datos.getBooleanValue
import com.example.sori_records_grupo01tk.datos.getIntValue
import com.example.sori_records_grupo01tk.datos.saveBooleanValue
import com.example.sori_records_grupo01tk.datos.saveIntValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class DataStoreTest {

    private lateinit var mockContext: Context
    private lateinit var dataStore: DataStore<Preferences>

    // Define the keys as in your main class
    private val IS_LOGGED_IN = booleanPreferencesKey("isLoggedIn")
    private val ID_KEY = intPreferencesKey("numero_key")

    @Before
    fun setUp() {

        mockContext = mock()

        dataStore = mock()


        whenever(mockContext.dataStore).thenReturn(dataStore)
    }

    @Test
    fun testSaveBooleanValue() = runTest {
        val mockPreferences = mock<Preferences> {
            on { this[IS_LOGGED_IN] } doReturn false
        }


        saveBooleanValue(mockContext, true)


        verify(dataStore).edit(any())
    }

    @Test
    fun testGetBooleanValue() = runTest {

        val mockPreferences = mock<Preferences> {
            on { this[IS_LOGGED_IN] } doReturn true
        }


        whenever(mockContext.dataStore.data).thenReturn(flowOf(mockPreferences))

        val result = getBooleanValue(mockContext).first()


        assertTrue(result)
    }

    @Test
    fun testSaveAndRetrieveIntValue() = runTest {
        val mockPreferences = mock<Preferences> {
            on { this[ID_KEY] } doReturn 5
        }


        saveIntValue(mockContext, 10)


        val result = getIntValue(mockContext).first()


        assertEquals(10, result)
    }

}