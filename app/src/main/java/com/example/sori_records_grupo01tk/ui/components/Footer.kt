package com.example.sori_records_grupo01tk.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Footer(){
    Text(
        text = "© Sori Records - TK",
        style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.onSurface),
        textAlign = TextAlign.Center, modifier = Modifier.padding(10.dp)
    )
}