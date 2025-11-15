package com.example.sori_records_grupo01tk.model

data class CartItem(
    val id: Int,
    val nombre: String,
    val price: Int,
    var quantity: Int = 1
)

