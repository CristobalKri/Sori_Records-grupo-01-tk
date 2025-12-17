package com.example.sori_records_grupo01tk.ui.utils

import android.content.Context
import android.location.Location
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng

object MapUtils {

    //ultima ubicación conocida
    fun getUserLoc(context: Context, onResult: (LatLng?) -> Unit) {
        val lugarUser = LocationServices.getFusedLocationProviderClient(context)
        lugarUser.lastLocation.addOnSuccessListener { location: Location? ->
            location?.let {
                onResult(LatLng(it.latitude, it.longitude))
            } ?: onResult(null)
        }
    }

    //Calcular distancia en metros entre dos lugares
    fun calcularDist(from: LatLng, to: LatLng): Float {
        val results = FloatArray(1)
        Location.distanceBetween(
            from.latitude, from.longitude,
            to.latitude, to.longitude,
            results
        )
        return results[0] // metros
    }
}
