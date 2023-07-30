package com.example.vending_machine.bag

import com.example.vending_machine.bag.currency.Cash
import com.example.vending_machine.bag.currency.Coin

class Wallet(private val cash: Cash, private val coin: Coin) {

    fun monetaryAmount(): Int = (cash.exchange() + coin.exchange()).amount

    fun cashAmount(): Int = cash.amount

    fun coinAmount(): Int = coin.amount

}
