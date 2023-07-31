package com.example.vending_machine.bag.currency

class Coin(amount: Int): Currency(amount = amount) {

    override fun exchange(): Monetary = Monetary(amount = amount * COIN_UNIT)

    operator fun minus(other: Coin): Coin = Coin(amount = this.amount - other.amount)
}
