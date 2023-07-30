package com.example.vending_machine

import com.example.vending_machine.bag.Wallet
import com.example.vending_machine.bag.currency.Cash
import com.example.vending_machine.bag.currency.Coin
import com.example.vending_machine.view.InputView
import com.example.vending_machine.view.ResultView

fun main() {
    val (cashAmount, coinAmount) = InputView.insertCurrency()

    val wallet = Wallet(
        cash = Cash(amount = cashAmount),
        coin = Coin(amount = coinAmount),
    )

    ResultView.printCurrentCurrency(wallet = wallet)
}
