package com.example.sori_records_grupo01tk.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sori_records_grupo01tk.R
import com.example.sori_records_grupo01tk.model.Album
import com.example.sori_records_grupo01tk.ui.components.Footer
import com.example.sori_records_grupo01tk.ui.theme.PrimaryColor
import com.example.sori_records_grupo01tk.ui.theme.TextOnDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAlbum(
    tipoPre: String,
    onSave: (Album) -> Unit,
    navController: NavController
) {
    //por ahora
    var title by remember { mutableStateOf("") }
    var artista by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var descri by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf(tipoPre) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = PrimaryColor)
        ) {
            Text("Volver Atrás", style = MaterialTheme.typography.bodyLarge)
        }
        HorizontalDivider(color = Color.DarkGray, thickness = 1.dp)
        Spacer(modifier = Modifier.height(8.dp))

        //ACIONES
        Text("Agregar nuevo $tipo", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier
            .height(8.dp))


        OutlinedTextField(value = title,
            onValueChange = { title = it }, label = { Text("Título") })
        OutlinedTextField(value = artista,
            onValueChange = { artista = it }, label = { Text("Artista") })
        OutlinedTextField(value = precio,
            onValueChange = { precio = it }, label = { Text("Precio") },
            keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
        )
        OutlinedTextField(value = descri, onValueChange = { descri = it },
            label = { Text("Descripción") })

        //TIPO
        var expanded by remember { mutableStateOf(false) }
        Box {
            OutlinedButton(onClick = { expanded = true }) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)

                    Spacer(modifier = Modifier
                        .width(8.dp))
                    Text("Tipo",
                        style = MaterialTheme.typography.bodyLarge)
                }
            }

            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                listOf("Vinilo", "Cassette", "CD").forEach {
                    DropdownMenuItem(
                        text = { Text(it) },
                        onClick = {
                            tipo = it
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier
            .height(8.dp))


        //GUARDAR
        Button(
            onClick = {
                val nuevoAlbum = Album(
                    id = TODO(),
                    title = TODO(),
                    artista = TODO(),
                    cover = R.drawable.img_error,
                    precio = TODO(),
                    descri = TODO(),
                    tipo = TODO()
                )
                onSave(nuevoAlbum)
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor,
            contentColor = TextOnDark)
        ) {
            Text("Guardar",
                style = MaterialTheme.typography.bodyLarge)
        }

        Footer()
    }
}
