package com.example.vending_machine.bag.currency

sealed class Currency<T> {

    abstract fun exchange(): T

    companion object {
        internal const val COIN_UNIT: Int = 500
        internal const val CASH_UNIT: Int = 1000
    }
}
