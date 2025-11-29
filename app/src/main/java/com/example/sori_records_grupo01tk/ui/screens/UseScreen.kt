package com.example.sori_records_grupo01tk.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.example.sori_records_grupo01tk.viewmodel.UsuarioViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UseScreen(usuarioViewModel: UsuarioViewModel) {


    LaunchedEffect(Unit) {
        usuarioViewModel.fetchUsuarios()
    }

    val usuarioList = usuarioViewModel.usuarioList.collectAsState().value

    LazyColumn {
        items(usuarioList) { usuario ->
            Text("id: ${usuario.id}, Name: ${usuario.nombre}, Email: ${usuario.correo}, Contraseña: ${usuario.clave}")
        }
    }
}
