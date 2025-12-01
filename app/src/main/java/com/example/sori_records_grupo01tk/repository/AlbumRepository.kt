package com.example.sori_records_grupo01tk.repository

import com.example.sori_records_grupo01tk.Api.RetrofitInstance
import com.example.sori_records_grupo01tk.Api.RetrofitInstance.apiService
import com.example.sori_records_grupo01tk.model.Album
import retrofit2.Response

class AlbumRepository {

    suspend fun getAlbums(): Response<List<Album>> {
        return RetrofitInstance.apiService.getAlbums()
    }

    suspend fun getAlbum(id: Int): Response<Album> {
        return apiService.getAlbum(id)
    }

    suspend fun updateAlbum(id: Int, album: Album): Response<Album> {
        return apiService.updateAlbum(id, album)
    }

    suspend fun deleteAlbum(id: Int): Response<Unit> {
        return apiService.deleteAlbum(id)
    }

}