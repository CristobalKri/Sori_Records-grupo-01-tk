package com.example.sori_records_grupo01tk.ui.screens

import android.graphics.Bitmap
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sori_records_grupo01tk.ui.utils.guardarImagen
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.example.sori_records_grupo01tk.ui.components.Footer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PagoCompletado(){
    val qrInfo = "Compra exitosa #${(10000..40000).random()}"
    val qrBitmap = remember{ generateQR(qrInfo) }
    val context = LocalContext.current

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.size(50.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        qrBitmap?.let{
            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = "Codigo QR",
                modifier = Modifier
                    .size(220.dp)
                    .background(MaterialTheme.colorScheme.onSecondary,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(12.dp)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Guarda el código para retirar tu producto.",
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            qrBitmap?.let {
                guardarImagen(context, it, "codigo_qr_${System.currentTimeMillis()}")

                Toast.makeText(
                    context,
                    "Imagen guardada en la galería",
                    Toast.LENGTH_LONG
                ).show()
            }
        }) {
            Text("Guardar QR")
        }

        Footer()
    }
}

fun generateQR(text: String, size: Int = 400): Bitmap? {
    return try {
        val encoder = BarcodeEncoder()
        encoder.encodeBitmap(
            text,
            BarcodeFormat.QR_CODE,
            size,
            size
        )
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}