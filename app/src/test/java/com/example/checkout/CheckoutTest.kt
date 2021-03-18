package com.example.checkout

import junit.framework.Assert.assertEquals
import org.junit.Test

class CheckoutTest {

    @Test
    fun givenProductListWhenThisIsEmptyThenResponseIs504() {
        val service = CheckoutService()
        val products: List<Product> = ArrayList()
        val api: ApiPayment = ApiPaymentStub()
        val response = service.checkout(products, CreditCard(0.03f), api)
        assertEquals(ApiStatus.AMOUNT_INVALID.status, response.code)
    }

    @Test
    fun givenProductListWhenCreditCardTaxIsZeroThenResponseIs504() {
        val service = CheckoutService()
        val products: List<Product> = ArrayList()
        val api: ApiPayment = ApiPaymentStub()
        val response = service.checkout(products, CreditCard(0f), api)
        assertEquals(ApiStatus.AMOUNT_INVALID.status, response.code)
    }

    @Test
    fun givenProductListWhenThisIsCorrectButOutOfMoneyThenResponseIs503() {
        val service = CheckoutService()
        val products: List<Product> = ArrayList()
        val api: ApiPayment = ApiPaymentValidationStub(ApiStatus.OUT_OF_MONEY.status)
        val response = service.checkout(products, CreditCard(0.03f), api)
        assertEquals(ApiStatus.OUT_OF_MONEY.status, response.code)
    }

    @Test
    fun givenProductListWhenThisIsCorrectButCardNotValidThenResponseIs502() {
        val service = CheckoutService()
        val products: List<Product> = ArrayList()
        val api: ApiPayment = ApiPaymentValidationStub(ApiStatus.CARD_NOT_VALID.status)
        val response = service.checkout(products, CreditCard(0.03f), api)
        assertEquals(ApiStatus.CARD_NOT_VALID.status, response.code)
    }


    @Test
    fun shouldReturnSuccessWhenCheckoutIsOk() {
        val service = CheckoutService()
        val products: MutableList<Product> = ArrayList()
        products.add(Product("LK89232", 500))
        products.add(Product("LK89233", 500))
        val api: ApiPayment = ApiPaymentStub()
        val response = service.checkout(products, CreditCard(0.03f), api)
        assertEquals(ApiStatus.SUCCESS.status, response.code)
    }
}