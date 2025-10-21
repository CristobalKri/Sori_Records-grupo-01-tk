package com.example.sori_records_grupo01tk.ui.components

import android.content.Context
import android.location.Location
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import com.google.android.gms.location.LocationServices

@Composable
fun OSMMapScreen(context: Context, tiendas: List<Pair<String, GeoPoint>>) {
    // OSMDroid necesita configuración inicial
    LaunchedEffect(Unit) {
        Configuration.getInstance().load(context, context.getSharedPreferences("prefs", Context.MODE_PRIVATE))
    }

    AndroidView(
        factory = { ctx ->
            MapView(ctx).apply {
                setMultiTouchControls(true)
                controller.setZoom(13.0)

                // Marcadores de tiendas
                tiendas.forEach { (name, location) ->
                    val marker = Marker(this)
                    marker.position = location
                    marker.title = name
                    this.overlays.add(marker)
                }

                // Localización del usuario
                val fusedLocationClient = LocationServices.getFusedLocationProviderClient(ctx)
                fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                    location?.let {
                        val userMarker = Marker(this)
                        userMarker.position = GeoPoint(location.latitude, location.longitude)
                        userMarker.title = "Tú"
                        userMarker.icon = ctx.getDrawable(android.R.drawable.ic_menu_mylocation)
                        this.overlays.add(userMarker)
                        controller.setCenter(userMarker.position)
                    }
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}
