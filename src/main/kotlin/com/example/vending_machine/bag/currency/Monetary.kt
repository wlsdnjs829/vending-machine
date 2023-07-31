package com.example.vending_machine.bag.currency

class Monetary(val amount: Int) : Money() {

    override fun exchange(): Coin = Coin(amount = amount / COIN_UNIT)

    operator fun plus(other: Monetary): Monetary = Monetary(amount = this.amount + other.amount)
}
