package com.example.sori_records_grupo01tk.viewmodel

import android.app.Application
import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import com.example.sori_records_grupo01tk.datos.getBooleanValue
import com.example.sori_records_grupo01tk.datos.getIntValue
import com.example.sori_records_grupo01tk.datos.saveBooleanValue
import com.example.sori_records_grupo01tk.datos.saveIntValue
import com.example.sori_records_grupo01tk.viewmodel.LoginViewModel
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.*

@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()  // Ensures LiveData works synchronously in tests

    private lateinit var viewModel: LoginViewModel
    private val mockContext: Context = mock()

    // Coroutine test dispatcher
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)  // Set the main dispatcher for coroutines to use the test dispatcher

        // Mocking the dataStore functions to return mock flows
        whenever(getBooleanValue(mockContext)).thenReturn(flowOf(true))
        whenever(getIntValue(mockContext)).thenReturn(flowOf(42))

        // Initialize the ViewModel
        val mockContext: Application = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun `test boolean value flow updates correctly`() = runTest {
        // Wait until everything is done
        advanceUntilIdle()

        // Check the value in the ViewModel after the flow updates
        assert(viewModel.booleanValue.value == true)
    }

    @Test
    fun `test int value flow updates correctly`() = runTest {
        // Wait until everything is done
        advanceUntilIdle()

        // Check the value in the ViewModel after the flow updates
        assert(viewModel.numeroValue.value == 42)
    }

    @Test
    fun `test saveBoolean updates value correctly`() = runTest {
        // Call the suspend function saveBoolean within the coroutine scope
        viewModel.saveBoolean(false)

        // Wait for coroutines to finish
        advanceUntilIdle()

        // Verify that saveBooleanValue was called with the correct value
        verify { runBlocking { saveBooleanValue(mockContext, false) } }
    }

    @Test
    fun `test saveInt updates value correctly`() = runTest {
        // Call the suspend function saveInt within the coroutine scope
        viewModel.saveInt(99)

        // Wait for coroutines to finish
        advanceUntilIdle()

        // Verify that saveIntValue was called with the correct value
        verify { runBlocking { saveIntValue(mockContext, 99) } }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()  // Reset the dispatcher after tests to avoid side effects
    }
}
