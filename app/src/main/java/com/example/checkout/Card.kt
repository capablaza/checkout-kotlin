package com.example.checkout

open class Card(tax: Float) {
    val tax: Float = tax

    fun taxes(amount: Float) : Float {
        return (this.tax * amount)
    }
}