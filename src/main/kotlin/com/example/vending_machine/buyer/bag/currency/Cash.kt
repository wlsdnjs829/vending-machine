package com.example.vending_machine.buyer.bag.currency

class Cash(amount: Int): Currency(amount = amount) {

    override fun exchange(): Monetary = Monetary(amount = amount * CASH_UNIT)

    operator fun minus(other: Cash): Cash = Cash(amount = this.amount - other.amount)
}
