package com.example.checkout

class ApiPaymentValidationStub(code: Int) : ApiPayment {
    val code:Int = code

    override fun transfer(amountToPay: Float, card: Card?): ApiResponse {
        return ApiResponse(this.code, "")
    }
}