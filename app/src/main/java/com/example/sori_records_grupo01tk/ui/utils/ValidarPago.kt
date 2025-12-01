package com.example.sori_records_grupo01tk.ui.utils

import androidx.compose.ui.text.input.TextFieldValue
import java.util.Calendar

object ValidacionesPago {


    //VALIDAR TARJETA Y CHECKS
    fun validarDatosPago(
        numeroTarjeta: TextFieldValue,
        fechaVen: TextFieldValue,
        cvv: String,
        condiciones: Boolean
    ): String? {
        val tarjeta = Regex("^(\\d{4} ?){4}$")
        val cvvR = Regex("^\\d{3}$")
        val fechaR = Regex("^(0[1-9]|1[0-2])/\\d{2}$") // MES-AÑO

        val tarjetaText = numeroTarjeta.text.replace(" ", "")
        val fechaText = fechaVen.text
        //Tarjeta
        if (tarjetaText.isBlank() || !tarjetaText.matches(Regex("^\\d{16}$"))) {
            return "Número de tarjeta inválido (debe tener 16 dígitos)"
        }

        //CVV
        if (cvv.isBlank() || !cvv.matches(cvvR)) {
            return "CVV inválido (debe tener 3 dígitos)"
        }

        //fecha X_X
        if (fechaText.isBlank() || !fechaText.matches(fechaR)) {
            return "Fecha inválida (formato MM/AA)"
        }  else {
            val partes = fechaText.split("/")
            val mes = partes[0].toIntOrNull() ?: return "Mes inválido"
            val yearT = partes[1].toIntOrNull()?.plus(2000) ?: return "Año inválido" // AA - AAAA


            ///NO PASA
            val calendario = Calendar.getInstance()
            val yearNow = calendario.get(Calendar.YEAR)
            val mesNow = calendario.get(Calendar.MONTH) + 1

            if (yearT < yearNow || (yearT == yearNow && mes < mesNow)) {
                return "La tarjeta es invalida"
            }
        }

        //Condiciones
        if (!condiciones) {
            return "Aceptar las condiciones de compra"
        }

        //if nice
        return null
    }


    ///AUTOMATICO '/'
    fun separarFecha(input: String): String {
        val digits = input.filter { it.isDigit() }
        return when {
            digits.length <= 2 -> digits
            digits.length <= 4 -> digits.substring(0, 2) + "/" + digits.substring(2)
            else -> digits.substring(0, 2) + "/" + digits.substring(2, 4)
        }
    }

    //AUTO TARJETA '1234 1234 1234 1234'
    fun separarTarjeta(input: String): String {
        val digits = input.filter { it.isDigit() }
        return digits.chunked(4).joinToString(" ").take(19)
    }
}
