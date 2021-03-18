package com.example.checkout

class CheckoutService {

    fun checkout(products: List<Product>, card: Card, api: ApiPayment): CheckoutResponse {
        val summary = Summary()

        val balance: Float = summary.balance(products)

        val taxes = card.taxes(balance)

        val amountToPay = balance + taxes

        val response = api.transfer(amountToPay, card)

        return when (response.code) {
            ApiStatus.CARD_NOT_VALID.status -> {
                CheckoutResponse(ApiStatus.CARD_NOT_VALID.status, response.message)
            }
            ApiStatus.OUT_OF_MONEY.status -> {
                CheckoutResponse(ApiStatus.OUT_OF_MONEY.status, response.message)
            }
            ApiStatus.AMOUNT_INVALID.status -> {
                CheckoutResponse(ApiStatus.AMOUNT_INVALID.status, response.message)
            }
            else -> CheckoutResponse(
                ApiStatus.SUCCESS.status,
                "payment process successfully"
            )
        }
    }
}