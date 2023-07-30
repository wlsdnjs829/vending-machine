package com.example.vending_machine.bag.currency

import com.example.vending_machine.bag.Wallet

class Monetary(val amount: Int) : Currency<Wallet>() {

    override fun exchange(): Wallet = Wallet(
        cash = Cash(amount = amount / CASH_UNIT),
        coin = Coin(amount = (amount % CASH_UNIT) / COIN_UNIT),
    )

    operator fun plus(other: Monetary): Monetary = Monetary(amount = this.amount + other.amount)
}
