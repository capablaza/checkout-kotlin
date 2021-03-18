package com.example.checkout

enum class ApiStatus(val status: Int) {
    SUCCESS(200),
    CARD_NOT_VALID(502),
    OUT_OF_MONEY(503),
    AMOUNT_INVALID(504)
}