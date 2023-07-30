package com.example.vending_machine.view

import com.example.vending_machine.view.model.CurrencyView

object InputView {

    private const val INSERT_CURRENCY_MESSAGE: String = "'룰루 얼마를 들고갈까?' (cash, coin)"

    fun insertCurrency(): CurrencyView {
        println(message = INSERT_CURRENCY_MESSAGE)
        return CurrencyView(inputText = readln())
    }
}
