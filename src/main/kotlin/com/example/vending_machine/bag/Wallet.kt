package com.example.vending_machine.bag

import com.example.vending_machine.bag.currency.Cash
import com.example.vending_machine.bag.currency.Coin
import com.example.vending_machine.bag.currency.Currency

class Wallet(private var cash: Cash, private var coin: Coin) {

    fun monetaryAmount(): Int = (cash.exchange() + coin.exchange()).amount

    fun cashAmount(): Int = cash.amount

    fun coinAmount(): Int = coin.amount

    fun takeOutCurrency(currency: Currency) = when (currency) {
        is Cash -> cash -= currency
        is Coin -> coin -= currency
    }
}
