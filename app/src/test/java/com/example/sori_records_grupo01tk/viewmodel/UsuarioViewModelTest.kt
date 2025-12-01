package com.example.sori_records_grupo01tk.viewmodel

import com.example.sori_records_grupo01tk.Api.ApiService
import com.example.sori_records_grupo01tk.model.Usuario
import com.google.gson.Gson
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class UsuarioViewModelTest {


    lateinit var mockWebServer: MockWebServer
    lateinit var apiService: ApiService
    private val gson = Gson()

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }

    @Test
    fun testGetUsuarios() = runTest {
        val mockResponse = MockResponse()
        mockResponse.setBody("[]")
        mockWebServer.enqueue(mockResponse)

        val response = apiService.getUsuarios()
        mockWebServer.takeRequest()

        Assert.assertEquals(true, response.body()!!.isEmpty())
    }


    @Test
    fun testGetUsuario() = runTest {
        val mockUser = Usuario(id = 1L, nombre = "Juan Perez", correo = "juan@example.com", clave = "123", direccion = "Street 123")
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(gson.toJson(mockUser))
        mockWebServer.enqueue(mockResponse)

        val response = apiService.getUsuario(1)
        val request = mockWebServer.takeRequest()

        assertEquals("/usuarios/1", request.path)
        assertTrue(response.isSuccessful)
        assertNotNull(response.body())
        assertEquals(1L, response.body()!!.id)
        assertEquals("Juan Perez", response.body()!!.nombre)
    }

    @Test
    fun testUpdateUsuario() = runTest {
        val userToUpdate = Usuario(id = 1L, nombre = "Juan Updated", correo = "juan@example.com", clave = "123", direccion = "Street 123")
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(gson.toJson(userToUpdate))
        mockWebServer.enqueue(mockResponse)

        val response = apiService.updateUsuario(1, userToUpdate)
        val request = mockWebServer.takeRequest()

        val requestBody = gson.fromJson(request.body.readUtf8(), Usuario::class.java)
        assertEquals("/usuarios/1", request.path)
        assertEquals("PUT", request.method)
        assertEquals("Juan Updated", requestBody.nombre)

        assertTrue(response.isSuccessful)
        assertEquals("Juan Updated", response.body()!!.nombre)
    }

    @Test
    fun testDeleteUsuario() = runTest {
        val mockResponse = MockResponse()
            .setResponseCode(204)
            .setBody("")
        mockWebServer.enqueue(mockResponse)

        val response = apiService.deleteUsuario(1)
        val request = mockWebServer.takeRequest()

        assertEquals("/usuarios/1", request.path)
        assertEquals("DELETE", request.method)
        assertTrue(response.isSuccessful)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

}
