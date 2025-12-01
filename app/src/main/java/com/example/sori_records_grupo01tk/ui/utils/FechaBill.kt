package com.example.sori_records_grupo01tk.ui.utils

import java.time.LocalDate
import java.time.DayOfWeek
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters

object FechaBill {

    fun getLastSat(): String {
        return try {
            val today = LocalDate.now()
            val lastSaturday = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SATURDAY))
            val formatted = lastSaturday.format(DateTimeFormatter.ISO_DATE)

            // si no deja sera fija
            if (lastSaturday.isAfter(LocalDate.of(2020, 1, 1))) {
                "2019-05-11"
            } else {
                formatted
            }
        } catch (e: Exception) {
            "2019-05-11"
        }
    }
}
