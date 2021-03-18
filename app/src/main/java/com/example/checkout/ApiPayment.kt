package com.example.checkout

interface ApiPayment {
    fun transfer(amountToPay: Float, card: Card?): ApiResponse
}