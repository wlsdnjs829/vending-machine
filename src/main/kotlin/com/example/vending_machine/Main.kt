package com.example.vending_machine

import com.example.vending_machine.buyer.Buyer
import com.example.vending_machine.buyer.event.CurrencyStateEvent
import com.example.vending_machine.buyer.event.InsertCurrencyEvent
import com.example.vending_machine.buyer.event.PurchaseEvent
import com.example.vending_machine.buyer.event.SituationEvent
import com.example.vending_machine.machine.VendingMachine
import com.example.vending_machine.view.InputView

fun main() {
    val buyer = Buyer(
        wallet = InputView.createWallet(),
        vendingMachine = VendingMachine(),
        currencyStateEvent = CurrencyStateEvent(),
    )

    buyer.currentState()

    buyer.useMachine(
        insertCurrencyEvent = InsertCurrencyEvent(),
        purchaseEvent = PurchaseEvent(),
        situationEvent = SituationEvent(),
    )

    buyer.currentState()
}
