package com.example.vending_machine.machine.product

import com.example.vending_machine.buyer.bag.currency.Monetary

class Stock(val product: Product, private var count: Int) {

    fun deduction() {
        require(value = count >= PURCHASE_COUNT) { "현재 재고가 없습니다" }

        count -= PURCHASE_COUNT
    }

    fun availableForPurchaseMonetary(): Monetary = product.monetary

    fun availableForPurchase(): Boolean = count >= PURCHASE_COUNT

    companion object {
        private const val PURCHASE_COUNT: Int = 1
    }
}
