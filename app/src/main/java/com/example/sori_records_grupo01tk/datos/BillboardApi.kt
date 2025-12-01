package com.example.sori_records_grupo01tk.datos

import com.example.sori_records_grupo01tk.model.BillboardResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface BillboardApi {
    @GET("hot-100")
    suspend fun getHot100(
        @Query("date") date: String,
        @Query("range") range: String,
        @Header("x-rapidapi-key") apiKey: String,
        @Header("x-rapidapi-host") host: String = "billboard-api2.p.rapidapi.com"
    ): BillboardResponse
}

