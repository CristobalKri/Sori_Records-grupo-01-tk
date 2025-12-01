package com.example.sori_records_grupo01tk.model

import com.google.gson.annotations.SerializedName

data class Usuario(
    val id: Long?,
    @SerializedName("userName") val nombre: String?,
    @SerializedName("password") val clave: String?,
    @SerializedName("email") val correo: String?,
    @SerializedName("address") val direccion: String?
)