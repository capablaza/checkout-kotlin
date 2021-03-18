package com.example.checkout


import org.junit.Assert
import org.junit.Test

class CardTest {

    @Test
    fun shouldReturn30WhenIsCreditCardAndAmountIs1000(){
        val card: Card = CreditCard(0.03f)
        val amount = 1000f
        val expected = 30f
        val taxes = card.taxes(amount)
        Assert.assertEquals(expected, taxes)
    }

    @Test
    fun shouldReturnZeroWithCreditCardAndAmountIsZero() {
        val card: Card = CreditCard(0.03f)
        val amount = 0f
        val expected = 0f
        val taxes = card.taxes(amount)
        Assert.assertEquals(expected, taxes)
    }

    @Test
    fun shouldReturnZeroWhenCreditCardTaxIsZero() {
        val card: Card = CreditCard(0f)
        val amount = 1000f
        val expected = 0f
        val taxes = card.taxes(amount)
        Assert.assertEquals(expected, taxes)
    }


    @Test
    fun shouldReturn30WhenIsDebitCardAndAmountIs1000() {
        val card: Card = DebitCard(0.015f)
        val amount = 1000f
        val expected = 15f
        val taxes = card.taxes(amount)
        Assert.assertEquals(expected, taxes)
    }

    @Test
    fun shouldReturnZeroWithDebitCardAndAmountIsZero() {
        val card: Card = DebitCard(0.015f)
        val amount = 0f
        val expected = 0f
        val taxes = card.taxes(amount)
        Assert.assertEquals(expected, taxes)
    }

    @Test
    fun shouldReturnZeroWhenDebitCardTaxIsZero() {
        val card: Card = DebitCard(0f)
        val amount = 1000f
        val expected = 0f
        val taxes = card.taxes(amount)
        Assert.assertEquals(expected, taxes)
    }
}