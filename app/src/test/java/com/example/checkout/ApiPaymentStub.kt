package com.example.checkout

class ApiPaymentStub : ApiPayment {
    
    override fun transfer(amountToPay: Float, card: Card?): ApiResponse {
        if (amountToPay <= 0) {
            return ApiResponse(ApiStatus.AMOUNT_INVALID.status, "The amount is not valid")
        }

        return ApiResponse(ApiStatus.SUCCESS.status, "the payment was success")
    }
}