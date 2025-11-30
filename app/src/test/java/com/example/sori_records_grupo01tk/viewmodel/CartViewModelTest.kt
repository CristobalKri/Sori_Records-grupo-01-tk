package com.example.sori_records_grupo01tk.viewmodel

import com.example.sori_records_grupo01tk.model.CartItem
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CartViewModelTest {

    private lateinit var cartViewModel: CartViewModel

    @Before
    fun setup() {
        cartViewModel = CartViewModel()
    }

    @Test
    fun addItemTest() {

        // Given
        val cartItem = CartItem(id = 1, nombre = "Album", price = 10, quantity = 1)

        // When
        cartViewModel.addItem(cartItem)

        // Then
        assertEquals(1, cartViewModel.cartItems.size)
        assertEquals(cartItem, cartViewModel.cartItems[0])
    }

    @Test
    fun increaseItemCart() {

        val cartItem = CartItem(id = 1, nombre = "Album", price = 10, quantity = 1)
        cartViewModel.addItem(cartItem)

        cartViewModel.addItem(cartItem)

        assertEquals(1, cartViewModel.cartItems.size)
        assertEquals(2, cartViewModel.cartItems[0].quantity)
    }

    @Test
    fun removeItemCart() {

        val cartItem1 = CartItem(id = 1, nombre = "Album 1", price = 10, quantity = 1)
        val cartItem2 = CartItem(id = 2, nombre = "Album 2", price = 20, quantity = 1)
        cartViewModel.addItem(cartItem1)
        cartViewModel.addItem(cartItem2)

        cartViewModel.removeItem(cartItem1)

        assertEquals(1, cartViewModel.cartItems.size)
        assertTrue(cartViewModel.cartItems.contains(cartItem2))
    }

    @Test
    fun updateItemCart() {

        val cartItem = CartItem(id = 1, nombre = "Album", price = 10, quantity = 1)
        cartViewModel.addItem(cartItem)

        cartViewModel.updateItemQuantity(cartItem, 5)

        assertEquals(5, cartViewModel.cartItems[0].quantity)
    }

    @Test
    fun getTotalItemCart() {

        val cartItem1 = CartItem(id = 1, nombre = "Album 1", price = 1000, quantity = 2)
        val cartItem2 = CartItem(id = 2, nombre = "Album 2", price = 2000, quantity = 1)
        cartViewModel.addItem(cartItem1)
        cartViewModel.addItem(cartItem2)

        val total = cartViewModel.getTotal()

        assertEquals(4000, total)
    }
}