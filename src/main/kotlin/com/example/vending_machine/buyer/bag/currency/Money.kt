package com.example.vending_machine.buyer.bag.currency

sealed class Money {

    abstract fun exchange(): Money

    companion object {
        internal const val COIN_UNIT: Int = 500
        internal const val CASH_UNIT: Int = 1000
    }
}
