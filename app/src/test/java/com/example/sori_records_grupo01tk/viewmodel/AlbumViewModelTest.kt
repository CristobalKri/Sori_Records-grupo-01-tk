package com.example.sori_records_grupo01tk.viewmodel

import androidx.core.R
import com.example.sori_records_grupo01tk.Api.ApiService
import com.example.sori_records_grupo01tk.model.Album
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class AlbumApiServiceTest {

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
    fun `getAlbums returns a list of albums`() = runTest {
        val mockAlbumList = listOf(
            Album(id = 1, title = "Titulo1", artista = "Artista1", cover = 1, precio = 10000, descri = "Descri1", tipo = "Casette")
        )
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(gson.toJson(mockAlbumList))
        mockWebServer.enqueue(mockResponse)

        val response = apiService.getAlbums()
        val request = mockWebServer.takeRequest()

        assertEquals("/albums", request.path)
        assertTrue(response.isSuccessful)
        assertNotNull(response.body())
        assertEquals(1, response.body()!!.size)
        assertEquals("Titulo1", response.body()!![0].title)
    }

    @Test
    fun `getAlbum returns a single album`() = runTest {
        val mockAlbum = Album(id = 1, title = "Titulo1", artista = "Artista1", cover = 1, precio = 10000, descri = "Descri1", tipo = "Casette")
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(gson.toJson(mockAlbum))
        mockWebServer.enqueue(mockResponse)

        val response = apiService.getAlbum(1)
        val request = mockWebServer.takeRequest()

        assertEquals("/albums/1", request.path)
        assertTrue(response.isSuccessful)
        assertNotNull(response.body())
        assertEquals(1, response.body()!!.id)
        assertEquals("Titulo1", response.body()!!.title)
    }

    @Test
    fun `updateAlbum sends an album and gets it back`() = runTest {
        val albumToUpdate = Album(id = 1, title = "Titulo1", artista = "Artista1", cover = 1, precio = 10000, descri = "Descri1", tipo = "Casette")
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(gson.toJson(albumToUpdate))
        mockWebServer.enqueue(mockResponse)

        val response = apiService.updateAlbum(1, albumToUpdate)
        val request = mockWebServer.takeRequest()

        val requestBody = gson.fromJson(request.body.readUtf8(), Album::class.java)
        assertEquals("/albums/1", request.path)
        assertEquals("PUT", request.method)
        assertEquals("Titulo1", requestBody.title)

        assertTrue(response.isSuccessful)
        assertEquals("Titulo1", response.body()!!.title)
    }

    @Test
    fun `deleteAlbum completes successfully`() = runTest {
        val albumToDelete = Album(id = 1, title = "Titulo1", artista = "Artista1", cover = 1, precio = 10000, descri = "Descri1", tipo = "Casette")
        val mockResponse = MockResponse()
            .setResponseCode(204) // No Content
            .setBody("")
        mockWebServer.enqueue(mockResponse)

        val response = apiService.deleteAlbum(1)
        val request = mockWebServer.takeRequest()

        assertEquals("/albums/1", request.path)
        assertEquals("DELETE", request.method)
        assertTrue(response.isSuccessful)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}
