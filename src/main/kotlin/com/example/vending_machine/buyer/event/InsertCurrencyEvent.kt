package com.example.vending_machine.buyer.event

import com.example.vending_machine.buyer.bag.currency.Currency
import com.example.vending_machine.view.InputView

class InsertCurrencyEvent(
    val useMachineEvent: () -> Boolean = { InputView.useMachine().isProgress() },
    val inputCurrencyEvent: () -> Currency = { InputView.insertMoney() },
    val continueEvent: () -> Boolean = { InputView.continueInsertMoney().isProgress() },
)
