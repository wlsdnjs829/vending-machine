package com.example.vending_machine.bag.currency

class Cash(val amount: Int): Currency<Monetary>() {

    override fun exchange(): Monetary = Monetary(amount = amount * CASH_UNIT)
}
