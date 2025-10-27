package com.example.sori_records_grupo01tk.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.sori_records_grupo01tk.R
import com.example.sori_records_grupo01tk.ui.theme.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext

import androidx.navigation.NavController
import com.example.sori_records_grupo01tk.ui.components.Footer
import com.example.sori_records_grupo01tk.viewmodel.LoginViewModel
import com.example.sori_records_grupo01tk.viewmodel.UsuarioViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: UsuarioViewModel = viewModel(),
    loginviewModel: LoginViewModel = viewModel()
) {

    val estadoLogin by viewModel.login.collectAsState()
    val isLoggedIn = loginviewModel.booleanValue.collectAsState()
    val context = LocalContext.current



    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_2),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White),
                    modifier = Modifier
                        .height(180.dp)
                        .fillMaxWidth()
                        .graphicsLayer {
                            alpha = 0.3f
                            translationY = 20f
                            shadowElevation = 0f
                            shape = RoundedCornerShape(12.dp)
                            clip = false
                        }
                        .blur(20.dp)
                )


                Image(
                    painter = painterResource(id = R.drawable.logo_2),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(180.dp)
                        .fillMaxWidth()
                )
            }

            OutlinedTextField(
                value = estadoLogin.nombre,
                onValueChange = viewModel::onNombreLoginChange,
                label = { Text(text = "Usuario") },
                isError = estadoLogin.errores.nombre != null,
                supportingText = {
                    estadoLogin.errores.nombre?.let {
                        Text(text= it, color = MaterialTheme.colorScheme.error)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = estadoLogin.clave,
                onValueChange = viewModel::onClaveLoginChange,
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(6.dp))

            Button(
                onClick = {
                    if (viewModel.validarLogin()) {
                        loginviewModel.saveBoolean(!isLoggedIn.value)
                        navController.navigate("homescreen")

                    } else {
                        Toast.makeText(
                            context,
                            "Usuario y/o contaseña incorrecta",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryColor,
                    contentColor = TextOnDark)
            ) {
                Text("Iniciar sesión")
            }

            HorizontalDivider(thickness = 2.dp)

            Button(
                onClick = {
                    navController.navigate("registro")
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ErrorColor,
                    contentColor = TextOnDark)
            ) {
                Text("Crear cuenta")
            }

            Footer()

        }
    }
}
