package com.example.sori_records_grupo01tk.ui.utils

object ValidarAddAlbum {

    fun validarAlbum(
        title: String,
        artista: String,
        precio: String,
        descri: String,
        tipo: String
    ): String? {

        if (title.isBlank()) {
            return "El título no puede estar vacío"
        }


        if (artista.isBlank()) {
            return "El artista no puede estar vacío"
        }


        val precioInt = precio.toIntOrNull()
        if (precioInt == null || precioInt <= 0) {
            return "El precio debe ser un número mayor a 0"
        }


        if (descri.isBlank() || descri.length < 1) {
            return "La descripción debe tener al menos 10 caracteres"
        }


        val tiposValidos = listOf("Vinilo", "Cassette", "CD")
        if (tipo.isBlank() || tipo !in tiposValidos) {
            return "El tipo debe ser valido: Vinilo, Cassette o CD"
        }

        return null
    }
}
