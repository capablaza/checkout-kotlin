package com.example.checkout

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class SummaryTest {

    lateinit var summary: Summary

    @Before
    fun setUp(){
        this.summary = Summary()
    }
    
    @Test
    fun givenTwoProductsWhenBothAvail500ThenBalanceIs1000() {
        val products: MutableList<Product> = ArrayList()
        products.add(Product("LK89232", 500))
        products.add(Product("LK89233", 500))
        val expected = 1000f
        val balance: Float = summary.balance(products)
        assertEquals(expected, balance)
    }

    @Test
    fun shouldReturnZeroWhenListProductIsEmpty() {
        val products: List<Product> = ArrayList()
        val expected = 0f
        val balance: Float = summary.balance(products)
        assertTrue(products.isEmpty())
        assertEquals(expected, balance)
    }

    @Test
    fun shouldReturnZeroWhenBothsProductsHaveValueIdenticalButOpposite() {
        val products: MutableList<Product> = ArrayList()
        products.add(Product("LK89232", -500))
        products.add(Product("LK89233", 500))
        val expected = 0f
        val balance: Float = summary.balance(products)
        assertEquals(expected, balance)
    }

    @Test
    fun givenProductValueIs500WhenProductValueIsNegativeThenReturnBalanceNegative() {
        val products: MutableList<Product> = ArrayList()
        products.add(Product("LK89232", -1500))
        products.add(Product("LK89233", 500))
        val expected = -1000f
        val balance: Float = summary.balance(products)
        assertEquals(expected, balance)
    }
}