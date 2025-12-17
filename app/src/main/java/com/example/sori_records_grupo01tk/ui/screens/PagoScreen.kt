package com.example.sori_records_grupo01tk.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.sori_records_grupo01tk.ui.components.Footer
import com.example.sori_records_grupo01tk.ui.theme.PrimaryColor
import com.example.sori_records_grupo01tk.ui.theme.TextOnDark
import com.example.sori_records_grupo01tk.viewmodel.UsuarioViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import com.example.sori_records_grupo01tk.ui.utils.ValidacionesPago
import com.example.sori_records_grupo01tk.viewmodel.CartViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PagoScreen(
    navController: NavController,
    usuarioViewModel: UsuarioViewModel = viewModel(),
    cartViewModel: CartViewModel = viewModel()
) {
    val userL = usuarioViewModel.login.collectAsState().value
    val context = LocalContext.current

    val cartItems = cartViewModel.cartItems
    val total = cartViewModel.getTotal()


    //NO HAY CUENTA
    if (userL.nombre.isBlank()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Debes iniciar sesión para continuar con el pago")

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { navController.navigate("login") },
                modifier = Modifier.fillMaxWidth(0.5f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryColor,
                    contentColor = TextOnDark
                )
            ) {
                Text("Ir a Login")
            }

            Footer()
        }
    } else {


        //HAY CUENTA
        var nTarjeta by remember { mutableStateOf(TextFieldValue("")) }
        var condiciones by remember { mutableStateOf(false) }
        var fechaVen by remember { mutableStateOf(TextFieldValue("")) }
        var cvv by remember { mutableStateOf("") }
        var suscripcionPromos by remember { mutableStateOf(false) }

        val items = cartItems.map { it.nombre to it.price }
        val total = cartViewModel.getTotal()

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                //RESUMEN
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                        .padding(16.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            "Resumen del pedido",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.Black
                        )

                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            items.forEach { (nombre, precio) ->
                                Text("$nombre - $$precio", color = Color.Black)
                            }
                        }
                    }
                }
            }

            //TOTAL

            item {
                Text("Total: $$total",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge)

                Spacer(modifier = Modifier
                    .height(16.dp))

                HorizontalDivider(color = Color.DarkGray, thickness = 1.dp)
            }


            ///SEGURO YEAH
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(top = 12.dp)
                ) {
                    Icon(
                        Icons.Default.Lock,
                        contentDescription = "Pago seguro",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text("Pago seguro y encriptado", style = MaterialTheme.typography.bodyMedium)
                }
            }


            ///TARJETA
            item {
                OutlinedTextField(
                    value = nTarjeta,
                    onValueChange = { input ->
                        val digits = input.text.filter { it.isDigit() }
                        val formatted = digits.chunked(4).joinToString(" ").take(19)
                        nTarjeta = TextFieldValue(
                            text = formatted,
                            selection = TextRange(formatted.length) // cursor al final
                        )
                    },
                    label = { Text("Número de tarjeta") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        value = fechaVen,
                        onValueChange = { input ->
                            val digits = input.text.filter { it.isDigit() }
                            val formatted = when {
                                digits.length <= 2 -> digits
                                digits.length <= 4 -> digits.substring(0, 2) + "/" + digits.substring(2)
                                else -> digits.substring(0, 2) + "/" + digits.substring(2, 4)
                            }
                            fechaVen = TextFieldValue(
                                text = formatted,
                                selection = TextRange(formatted.length)
                            )
                        },
                        label = { Text("MM/AA") },
                        modifier = Modifier.weight(1f),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    OutlinedTextField(
                        value = cvv,
                        onValueChange = { cvv = it },
                        label = { Text("CVV") },
                        modifier = Modifier.weight(1f),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        visualTransformation = PasswordVisualTransformation()
                    )
                }
            }


            ///CHECKS
            item {
                Spacer(modifier = Modifier
                    .height(16.dp))

                HorizontalDivider(color = Color.DarkGray, thickness = 1.dp)

                Spacer(modifier = Modifier
                    .height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = condiciones, onCheckedChange = { condiciones = it })
                    Text("Acepto las condiciones de compra")
                }
            }

            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 2.dp)
                ) {
                    Checkbox(
                        checked = suscripcionPromos,
                        onCheckedChange = { suscripcionPromos = it })
                    Text("Deseo recibir novedades y promociones")
                }
            }


            ///CONTINUAR PROCESO
            item {
                Button(
                    onClick = {
                        val error =
                            ValidacionesPago.validarDatosPago(nTarjeta, fechaVen, cvv, condiciones)
                        if (error != null) {
                            Toast.makeText(context, error,
                                Toast.LENGTH_LONG).show()
                        } else {
                            navController.navigate("loading") {
                                popUpTo("carrito") { inclusive = true }
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = TextOnDark
                    )
                ) {
                    Text("Confirmar pago")
                }
            }

            item { Footer() }
        }
    }
}