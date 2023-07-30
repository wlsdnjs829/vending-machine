package com.example.vending_machine.view.model

data class CurrencyView(val cashAmount: Int, val coinAmount: Int) {

    constructor(inputText: String) : this(
        cashAmount = inputText.substringBefore(delimiter = DELIMITER)
            .trim()
            .toInt(),

        coinAmount = inputText.substringAfterLast(delimiter = DELIMITER)
            .trim()
            .toInt(),
    )

    companion object {
        private const val DELIMITER: Char = ','
    }
}
