package com.example.sori_records_grupo01tk.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sori_records_grupo01tk.ui.screens.Album

data class Album(val id: Int, val title: String, val artista: String, val cover: Int )

@Composable
fun AlbumCard(album: Album){
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .width(130.dp)
            .height(150.dp),
        colors = CardDefaults.cardColors()
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(7.dp)
        ){ Image(
            painter = painterResource(id = album.cover),
            contentDescription = album.title,
            modifier = Modifier.padding(7.dp)
        )
            Text(album.title, fontWeight = FontWeight.Bold)
            Text(album.artista, fontWeight = FontWeight.Bold)
        }
    }
}