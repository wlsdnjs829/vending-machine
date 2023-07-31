package com.example.vending_machine.buyer.bag.currency

sealed class Currency(val amount: Int) : Money() {

    init {
        require(value = amount >= MIN_AMOUNT) {
            "Currency 총액은 음수일 수 없습니다. 입력값 : $amount"
        }
    }

    abstract override fun exchange(): Monetary

    companion object {
        private const val MIN_AMOUNT: Int = 0
    }
}
