package com.example.sori_records_grupo01tk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sori_records_grupo01tk.model.Album
import com.example.sori_records_grupo01tk.ui.theme.Sori_RecordsGrupo01TKTheme
import com.example.sori_records_grupo01tk.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sori_RecordsGrupo01TKTheme(
                darkTheme = isSystemInDarkTheme(),
                dynamicColor = false
            ) {
                AppNavigation()
            }
            }
        }
    }
