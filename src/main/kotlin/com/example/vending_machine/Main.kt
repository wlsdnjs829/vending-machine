package com.example.vending_machine

import com.example.vending_machine.view.InputView
import com.example.vending_machine.view.ResultView

fun main() {
    val wallet = InputView.createWallet()
    ResultView.printCurrentCurrency(wallet = wallet)

    val vendingMachine = VendingMachine()
    ResultView.printMachineChanges(vendingMachine = vendingMachine)

    while (InputView.useMachine().isProgress()) {
        vendingMachine.insertCurrency(
            inputCurrencyEvent = { InputView.insertMoney() },
            takeOutCurrencyEvent = { currency -> wallet.takeOutCurrency(currency = currency) },
            continueEvent = { InputView.continueInsertMoney().isProgress() },
        )
    }

    ResultView.printCurrentCurrency(wallet = wallet)
    ResultView.printMachineChanges(vendingMachine = vendingMachine)
}
