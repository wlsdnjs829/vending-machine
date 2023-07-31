package com.example.vending_machine.machine

import com.example.vending_machine.buyer.bag.currency.Coin
import com.example.vending_machine.buyer.bag.currency.Currency
import com.example.vending_machine.buyer.bag.currency.Monetary
import com.example.vending_machine.buyer.event.PurchaseEvent
import com.example.vending_machine.buyer.event.SituationEvent
import com.example.vending_machine.machine.product.Product
import com.example.vending_machine.machine.product.Stock
import com.example.vending_machine.machine.product.Stocks

class VendingMachine(
    private var monetary: Monetary = Monetary(amount = ZERO),
    private val stocks: Stocks = Stocks(
        stocks = listOf(
            Stock(product = Product.COLA, count = DEFAULT_STOCK_COUNT),
            Stock(product = Product.ZERO_COLA, count = DEFAULT_STOCK_COUNT),
            Stock(product = Product.FANTA, count = DEFAULT_STOCK_COUNT),
            Stock(product = Product.WATER, count = DEFAULT_STOCK_COUNT),
            Stock(product = Product.TEJAVA, count = DEFAULT_STOCK_COUNT),
        ),
    ),
) {

    fun changes(): Int = monetary.amount

    fun takeOutCoin(): Coin {
        val coin = monetary.exchange()
        monetary -= monetary
        return coin
    }

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

    fun purchase(
        purchaseEvent: PurchaseEvent,
        situationEvent: SituationEvent,
        putInCoinEvent: (Coin) -> Unit,
    ) {
        check(value = stocks.availableForPurchaseAnyProducts()) { "더이상 자판기를 이용할 수 없습니다." }

        val stock = stocks.stock(product = purchaseEvent.purchaseProductEvent())
        val purchaseMonetary = stock.availableForPurchaseMonetary()

        if (monetary < purchaseMonetary) {
            situationEvent.notAvailableForPurchaseEvent()
            return
        }

        monetary -= purchaseMonetary
        stock.decrease()

        if (purchaseEvent.getChangesEvent()) {
            putInCoinEvent(takeOutCoin())
            situationEvent.purchaseSoundEvent()
        }
    }

    companion object {
        private const val ZERO: Int = 0
        private const val DEFAULT_STOCK_COUNT: Int = 3
    }
}
