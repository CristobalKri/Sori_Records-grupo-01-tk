package com.example.sori_records_grupo01tk.ui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.sori_records_grupo01tk.model.AlbumTwo
import com.example.sori_records_grupo01tk.model.CartItem
import com.example.sori_records_grupo01tk.ui.theme.*
import com.example.sori_records_grupo01tk.viewmodel.CartViewModel


@Composable
fun SecondAlbumCard(albumTwo: AlbumTwo,
){
    Card(
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
            AsyncImage(
                model = albumTwo.cover,
                contentDescription = albumTwo.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(6.dp))

            Box (modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(6.dp),
                    clip = false
                )
                .background(MaterialTheme.colorScheme.onBackground)
                .height(90.dp)
                .fillMaxSize(),
                Alignment.Center,
            ){
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center)
                {
                    Text(
                        albumTwo.title,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.background
                    )
                    Text(
                        text = "$${albumTwo.precio}",
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(top = 4.dp),
                        color = MaterialTheme.colorScheme.background
                    )
                }
            }
            Spacer(modifier = Modifier.height(6.dp))


        }
    }
}