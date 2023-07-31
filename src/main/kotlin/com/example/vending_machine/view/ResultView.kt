package com.example.vending_machine.view

import com.example.vending_machine.VendingMachine
import com.example.vending_machine.bag.Wallet

object ResultView {

    fun printCurrentCurrency(wallet: Wallet) = println(
        message = "\n현재 잔액: ${wallet.monetaryAmount()}(cash - ${wallet.cashAmount()}, coin - ${wallet.coinAmount()})",
    )

    fun printMachineChanges(vendingMachine: VendingMachine) = println(
        message = "자판기 잔돈: ${vendingMachine.changes()}",
    )
}
