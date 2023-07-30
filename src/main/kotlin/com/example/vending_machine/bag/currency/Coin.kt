package com.example.vending_machine.bag.currency

data class Coin(private val amount: Int): Currency<Monetary>() {

    override fun exchange(): Monetary = Monetary(amount = amount * COIN_UNIT)
}