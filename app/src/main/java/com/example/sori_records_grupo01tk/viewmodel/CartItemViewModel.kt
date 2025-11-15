package com.example.sori_records_grupo01tk.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.sori_records_grupo01tk.model.CartItem

class CartViewModel : ViewModel() {
    val cartItems = mutableStateListOf<CartItem>()

    // Add an item to the cart
    fun addItem(cartItem: CartItem) {
        val existingItem = cartItems.find { it.id == cartItem.id }
        if (existingItem != null) {
            existingItem.quantity += 1
        } else {
            cartItems.add(cartItem)
        }
    }

    // Remove an item from the cart
    fun removeItem(cartItem: CartItem) {
        cartItems.remove(cartItem)
    }

    // Update item quantity
    fun updateItemQuantity(cartItem: CartItem, newQuantity: Int) {
        val item = cartItems.find { it.id == cartItem.id }
        item?.quantity = newQuantity
    }

    // Get the total price
    fun getTotal(): Int {
        return cartItems.sumOf { it.price * it.quantity }
    }
}
