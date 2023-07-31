package com.example.vending_machine.machine.product

class Stocks(stocks: List<Stock>) {

    private val stockMap: Map<Product, Stock> = stocks.associateBy { it.product }

    fun stock(product: Product): Stock = requireNotNull(value = stockMap[product]) { "상품이 존재하지 않습니다." }

    fun availableForPurchaseAnyProducts(): Boolean = stockMap.values.any { it.availableForPurchase() }
}
