package com.example.sori_records_grupo01tk.Api

import com.example.sori_records_grupo01tk.model.Usuario
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("usuarios")
    suspend fun getUsuarios(): Response<List<Usuario>>

}