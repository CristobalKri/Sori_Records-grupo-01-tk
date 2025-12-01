package com.example.sori_records_grupo01tk.repository

import com.example.sori_records_grupo01tk.Api.RetrofitInstance
import com.example.sori_records_grupo01tk.Api.RetrofitInstance.apiService
import com.example.sori_records_grupo01tk.model.Usuario
import retrofit2.Response

class UsuarioRepository {

    suspend fun getUsuarios(): Response<List<Usuario>> {
        return RetrofitInstance.apiService.getUsuarios()
    }

    suspend fun getUsuario(id: Int): Response<Usuario> {
        return apiService.getUsuario(id)
    }

    suspend fun updateUsuario(id: Int, usuario: Usuario): Response<Usuario> {
        return apiService.updateUsuario(id, usuario)
    }

    suspend fun deleteUsuario(id: Int): Response<Unit> {
        return apiService.deleteUsuario(id)
    }

}