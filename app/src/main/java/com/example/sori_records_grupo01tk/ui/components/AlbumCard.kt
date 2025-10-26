package com.example.sori_records_grupo01tk.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sori_records_grupo01tk.model.Album
import com.example.sori_records_grupo01tk.ui.theme.*


@Composable
fun AlbumCard(album: Album,
              navController: NavController){
    Card(
        onClick = { navController.navigate("producto/${album.id}") },
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .width(170.dp)
            .padding(6.dp)
            .height(280.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = SecondaryColor,
            contentColor = TextOnDark
        )
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(8.dp)
                .fillMaxHeight()
        ){
            Image(
                painter = painterResource(id = album.cover),
                contentDescription = album.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
            )

            Text(album.title, fontWeight = FontWeight.Bold, maxLines = 2, textAlign = TextAlign.Center)
            Text(
                text = "$${album.precio}",
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Button(
                onClick = {/*TODO*/},
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier
                    .height(35.dp)
                    .width(150.dp) ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryColor,
                    contentColor = TextOnDark
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text("Agregar al carrito", fontSize = 13.sp)
            }
        }
    }
}