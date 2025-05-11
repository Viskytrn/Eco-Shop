package com.example.EcoShop.ui.theme.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.EcoShop.model.CartItem



class CartViewModel : ViewModel() {
    private val _cartItems = mutableStateListOf<CartItem>()
    val cartItems: List<CartItem> get() = _cartItems

    fun addItem(item: CartItem) {
        _cartItems.add(item)
    }

    fun removeItem(item: CartItem) {
        _cartItems.remove(item)
    }

    fun clearCart() {
        _cartItems.clear()
    }

    fun totalPrice(): Double = _cartItems.sumOf { it.price * it.quantity }
}
