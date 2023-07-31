package com.example.vending_machine.view.model

import com.example.vending_machine.buyer.bag.currency.Cash
import com.example.vending_machine.buyer.bag.currency.Coin
import com.example.vending_machine.buyer.bag.currency.Currency

enum class MoneyCommand(private val command: String) {
    CASH(command = "cash") {
        override fun toCurrency(amount: Int): Cash = Cash(amount = amount)
    },

    COIN(command = "coin") {
        override fun toCurrency(amount: Int): Coin = Coin(amount = amount)
    },
    ;

    abstract fun toCurrency(amount: Int): Currency

    companion object {
        fun valueOf(command: String) = values().find { it.command == command }
            ?: throw IllegalArgumentException("허용되지 않은 명령어입니다. 입력값 : $command")
    }
}
