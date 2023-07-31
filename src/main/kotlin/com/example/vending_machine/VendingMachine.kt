package com.example.vending_machine

import com.example.vending_machine.bag.currency.Currency
import com.example.vending_machine.bag.currency.Monetary

class VendingMachine(private var monetary: Monetary = Monetary(amount = ZERO)) {

    fun changes(): Int = monetary.amount

    tailrec fun insertCurrency(
        inputCurrencyEvent: () -> Currency,
        takeOutCurrencyEvent: (Currency) -> Unit,
        continueEvent: () -> Boolean,
    ) {
        val currency = inputCurrencyEvent()
        takeOutCurrencyEvent(currency)
        monetary += currency.exchange()

        if (continueEvent()) {
            insertCurrency(
                inputCurrencyEvent = inputCurrencyEvent,
                takeOutCurrencyEvent = takeOutCurrencyEvent,
                continueEvent = continueEvent,
            )
        }
    }

    companion object {
        private const val ZERO: Int = 0
    }
}
