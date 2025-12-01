package com.example.sori_records_grupo01tk.datos

import com.example.sori_records_grupo01tk.model.Usuario

object UserList{

    var users = mutableListOf<Usuario>(
        Usuario(
            id = 1,
            nombre = "Nombre1",
            clave =  "Clave123",
            correo =  "Correo@gmail.com",
            direccion =  "Direccion blahblah"
        ),
        Usuario(
            id = 1,
            nombre= "Nombre2",
            clave= "Clave123",
            correo = "Correo@gmail.com",
            direccion = "Direccion blahblahblah 2"
        )
    )

    fun addUser(usuario: Usuario) {
        users.add(usuario)
    }

}