package com.example.sori_records_grupo01tk.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.sori_records_grupo01tk.R
import com.example.sori_records_grupo01tk.ui.theme.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.navigation.NavController
import com.example.sori_records_grupo01tk.ui.components.Footer

@Composable
fun LoginScreen(
    navController: NavController
) {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


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
                value = user,
                onValueChange = { user = it },
                label = { Text("Usuario") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(6.dp))

            Button(
                onClick = {/*TODO*/},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryColor,
                    contentColor = TextOnDark)
            ) {
                Text("Iniciar sesión")
            }

            HorizontalDivider(thickness = 2.dp)

            Button(
                onClick = {/*TODO*/},
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
