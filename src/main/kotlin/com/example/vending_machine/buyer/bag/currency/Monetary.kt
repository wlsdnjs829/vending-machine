package com.example.vending_machine.buyer.bag.currency

class Monetary(val amount: Int) : Money(), Comparable<Monetary> {

    override fun exchange(): Coin = Coin(amount = amount / COIN_UNIT)

    operator fun plus(other: Monetary): Monetary = Monetary(amount = this.amount + other.amount)

    operator fun minus(other: Monetary): Monetary = Monetary(amount = this.amount - other.amount)

    override fun compareTo(other: Monetary): Int = this.amount.compareTo(other = other.amount)
}
