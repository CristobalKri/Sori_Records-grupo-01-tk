package com.example.sori_records_grupo01tk.repository

import com.example.sori_records_grupo01tk.Api.RetrofitInstance
import com.example.sori_records_grupo01tk.model.Usuario
import retrofit2.Response

class UsuarioRepository {

    suspend fun getUsuarios(): Response<List<Usuario>> {
        return RetrofitInstance.apiService.getUsuarios()
    }
}