package com.example.vending_machine.view

import com.example.vending_machine.bag.Wallet

object ResultView {

    fun printCurrentCurrency(wallet: Wallet) = println(
        message = "현재 잔액: ${wallet.monetaryAmount()}(cash - ${wallet.cashAmount()}, coin - ${wallet.coinAmount()})",
    )
}
