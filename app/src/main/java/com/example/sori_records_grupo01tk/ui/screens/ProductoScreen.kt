package com.example.sori_records_grupo01tk.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.sori_records_grupo01tk.model.Album
import com.example.sori_records_grupo01tk.ui.components.Footer
import com.example.sori_records_grupo01tk.ui.theme.*
import com.example.sori_records_grupo01tk.ui.utils.MapUtils
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.MapUiSettings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductoScreen(
    navController: NavController,
    album: Album) {
    val context = LocalContext.current

    var userLocation by remember { mutableStateOf<LatLng?>(null) }
    LaunchedEffect(Unit) { MapUtils.getUserLoc(context) {
        location -> userLocation = location } }



    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            AsyncImage(
                model = album.cover,
                contentDescription = album.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(220.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }

        item {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    album.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(12.dp))
                HorizontalDivider(thickness = 2.dp)
                Spacer(modifier = Modifier.height(12.dp))

                Text(album.artista, fontSize = 16.sp)
                Text(
                    "$${album.precio}",
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    album.descri,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { /* TODO */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = SecondaryColor,
                        contentColor = TextOnDark
                    )
                ) {
                    Text("Agregar al carrito")
                }
            }
        }

        item {
            HorizontalDivider(thickness = 2.dp)

            Text(
                "MAPA",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                GoogleMap(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),

                    cameraPositionState = rememberCameraPositionState {
                        position = CameraPosition.fromLatLngZoom(
                            userLocation ?: LatLng(-33.4489, -70.6693), 12f
                        )
                    },
                    uiSettings = MapUiSettings(
                        zoomControlsEnabled = true, // boton zoom
                        scrollGesturesEnabled = true, // arrastre
                        zoomGesturesEnabled = true// zoom
                    )
                ) {
                    // Marker usuario
                    userLocation?.let {
                        Marker(
                            state = MarkerState(position = it),
                            title = "Tu ubicación",
                            snippet = "Aquí estás"
                        )
                    }

                    // Markers tiendas
                    val tiendas = listOf(
                        LatLng(-33.429212106205924, -70.60679014692948),
                        LatLng(-33.43916361678069, -70.65757205124416),
                        LatLng(-33.366178816240065, -70.6783361905047)
                    )

                    tiendas.forEachIndexed { index, cords ->
                        val distancia = userLocation?.let { MapUtils.calcularDist(it, cords) }
                        Marker(
                            state = MarkerState(position = cords),
                            title = "Sori Records ${index + 1}",
                            snippet = distancia?.let { "A ${it.toInt()} metros" }
                                ?: "Ubicación aproximada",
                            icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)
                        )
                    }
                }
            }
        }

        item {
            Footer()
        }
    }
}