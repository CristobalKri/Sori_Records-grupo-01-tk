package com.example.sori_records_grupo01tk.Api

import com.example.sori_records_grupo01tk.model.Album
import com.example.sori_records_grupo01tk.model.Usuario
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @GET("usuarios")
    suspend fun getUsuarios(): Response<List<Usuario>>

    @GET("usuarios/{id}")
    suspend fun getUsuario(@Path("id") id: Int): Response<Usuario>

    @PUT("usuarios/{id}")
    suspend fun updateUsuario(@Path("id") id: Int, @Body usuario: Usuario): Response<Usuario>

    @DELETE("usuarios/{id}")
    suspend fun deleteUsuario(@Path("id") id: Int): Response<Unit>


    @GET("albums")
    suspend fun getAlbums(): Response<List<Album>>

    @GET("albums/{id}")
    suspend fun getAlbum(@Path("id") id: Int): Response<Album>

    @PUT("albums/{id}")
    suspend fun updateAlbum(@Path("id") id: Int, @Body album: Album): Response<Album>

    @DELETE("albums/{id}")
    suspend fun deleteAlbum(@Path("id") id: Int): Response<Unit>


}