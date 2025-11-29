package com.example.sori_records_grupo01tk.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sori_records_grupo01tk.model.UsuarioErrores
import com.example.sori_records_grupo01tk.model.UsuarioUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlin.collections.isNotEmpty
import kotlin.compareTo
import kotlin.text.contains
import kotlin.text.isBlank
import com.example.sori_records_grupo01tk.datos.UserList
import com.example.sori_records_grupo01tk.model.Usuario
import com.example.sori_records_grupo01tk.repository.UsuarioRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class UsuarioViewModel(application: Application)  : AndroidViewModel(application) {

    private val _estado = MutableStateFlow(value = UsuarioUiState())
    val estado: StateFlow<UsuarioUiState> = _estado

    private val _login = MutableStateFlow(value = UsuarioUiState())
    val login: StateFlow<UsuarioUiState> = _login

    private val usuarioRepository = UsuarioRepository()
    private val _usuarioList = MutableStateFlow<List<Usuario>>(emptyList())
    val usuarioList: StateFlow<List<Usuario>> = _usuarioList

    init {
        fetchUsuarios()
    }

    fun fetchUsuarios() {
        viewModelScope.launch {
                try {
                    val response = usuarioRepository.getUsuarios()
                    Log.d("API Response", "Response body: ${response.body()}")
                    response.body()?.let {
                        Log.d("API Response", it.toString())
                    }

                    if (response.isSuccessful) {
                        _usuarioList.value = response.body() ?: emptyList()
                    } else {
                        println("Error: ${response.message()}")
                    }
                } catch(e: Exception) {
                    println("Error al obtener datos: ${e.localizedMessage}")
                }
        }
    }



    fun onNombreChange(valor: String) {
        _estado.update { it.copy(nombre = valor, errores = it.errores.copy(nombre = null)) }
    }

    // Actualiza el campo correo
    fun onCorreoChange(valor: String) {
        _estado.update { it.copy(correo = valor, errores = it.errores.copy(correo = null)) }
    }

    // Actualiza el campo clave
    fun onClaveChange(valor: String) {
        _estado.update { it.copy(clave = valor, errores = it.errores.copy(clave = null)) }
    }

    // Actualiza el campo dirección
    fun onDireccionChange(valor: String) {
        _estado.update { it.copy(direccion = valor, errores = it.errores.copy(direccion = null)) }
    }

    // Actualiza checkbox de aceptación
    fun onAceptarTerminosChange(valor: Boolean) {
        _estado.update { it.copy(aceptaTerminos = valor) }
    }

    fun onNombreLoginChange(valor: String) {
        _login.update { it.copy(nombre = valor, errores = it.errores.copy(nombre = null)) }
    }

    fun onClaveLoginChange(valor: String) {
        _login.update { it.copy(clave = valor, errores = it.errores.copy(clave = null)) }
    }


    fun validarFormulario(): Boolean {
        val estadoActual = _estado.value

        val nameRegex = Regex("^[A-Za-z]+(?: [A-Za-z]+)*$")
        val mailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        val passwordRegex = Regex("^(?=.*[A-Za-z])(?=.*[^\\w\\s]).{7,}\\S+\$")

        val errores = UsuarioErrores(
            nombre = when {
                estadoActual.nombre.isBlank() -> "Campo obligatorio"
                !estadoActual.nombre.matches(nameRegex) -> "Nombre incorrecto, solo un nombre"
                else -> null
            },
            correo = when {
                !estadoActual.correo.contains("@") -> "Correo inválido"
                !estadoActual.correo.matches(mailRegex) -> "Correo invalido"
                else -> null
            },
            clave = when {
                !estadoActual.clave.matches(passwordRegex) -> "Debe tener al menos un simbolo y un numero, minimo de 7"
                else -> null
            },
            direccion = if (estadoActual.direccion.isBlank()) "Campo obligatorio" else null
        )


        val hayErrores = listOfNotNull(
            errores.nombre,
            errores.correo,
            errores.clave,
            errores.direccion
        ).isNotEmpty()

        _estado.update { it.copy(errores = errores) }

        return !hayErrores
    }

    fun validarLogin(): Boolean {
        val estadoActual = _login.value



        val user = usuarioList.value.find { it.nombre == estadoActual.nombre && it.clave == estadoActual.clave }

        if (user != null) {
            Log.d("Login", "Login found on: ${user.nombre}")
        } else {
            Log.d("Login", "Invalid credentials ${user}")
        }

        val errores = UsuarioErrores(
            nombre = when {
                estadoActual.nombre.isBlank() -> "Campo obligatorio"
                estadoActual.nombre != user?.nombre -> "Nombre y/o contraseña incorrecta"
                else -> null
            },
            clave = when {
                estadoActual.clave.isBlank() -> "Campo obligatorio"
                estadoActual.clave != user?.clave -> "Nombre y/o contraseña incorrecta"
                else -> null
            }
        )

        val hayErrores = listOfNotNull(
            errores.nombre,
            errores.clave
        ).isNotEmpty()

        _estado.update { it.copy(errores = errores) }

        return !hayErrores
    }
}