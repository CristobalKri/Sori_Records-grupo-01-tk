package com.example.sori_records_grupo01tk.datos

import android.util.Log
import com.example.sori_records_grupo01tk.model.Song
import com.google.gson.Gson

class BillboardRepository(private val api: BillboardApi) {

    suspend fun getTopSongs(): List<Song> {
        return try {
            val response = api.getHot100(
                date = "2019-05-11",
                range = "1-10",
                apiKey = API_KEY
            )

            response.content?.entrySet()?.map { entry ->
                Gson().fromJson(entry.value, Song::class.java)
            } ?: emptyList()
        } catch (e: Exception) {
            Log.e("BillboardRepository", "Error parseando JSON", e)
            emptyList()
        }
    }

    companion object {
        const val API_KEY = "198a81796amsh06d36373bfb8e68p14b57cjsnb1c340146fe9"
    }
}
