package com.example.checkout

class Summary {

    fun balance(products: List<Product>): Float {
        var sum = 0f

        for (p in products){
            sum += p.amount
        }
        return sum
    }
}