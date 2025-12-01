package com.example.sori_records_grupo01tk.Api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://web-attempt.onrender.com/"

    val loggingInterceptor = HttpLoggingInterceptor()

    var client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    var apiService: ApiService = retrofit.create(ApiService::class.java)
}
