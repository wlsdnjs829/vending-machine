package com.example.vending_machine.bag.currency

data class Cash(private val amount: Int): Currency<Monetary>() {

    override fun exchange(): Monetary = Monetary(amount = amount * CASH_UNIT)
}
