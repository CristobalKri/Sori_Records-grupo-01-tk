package com.example.sori_records_grupo01tk.repository

import com.example.sori_records_grupo01tk.Api.RetrofitInstance
import com.example.sori_records_grupo01tk.model.Album
import retrofit2.Response

class AlbumRepository {

    suspend fun getAlbums(): Response<List<Album>> {
        return RetrofitInstance.apiService.getAlbums()
    }

}