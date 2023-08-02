package com.example.vending_machine.machine.product

import com.example.vending_machine.buyer.bag.currency.Monetary

enum class Product(val monetary: Monetary, val exposureName: String) {
    COLA(
        monetary = Monetary(amount = 1_500),
        exposureName = "콜라",
    ),
    ZERO_COLA(
        monetary = Monetary(amount = 1_500),
        exposureName = "제로콜라",
    ),
    FANTA(
        monetary = Monetary(amount = 1_500),
        exposureName = "환타",
    ),
    WATER(
        monetary = Monetary(amount = 500),
        exposureName = "물",
    ),
    TEJAVA(
        monetary = Monetary(amount = 1_000),
        exposureName = "데자와",
    ),
    ;

    companion object {
        private val PRODUCT_MAP: Map<String, Product> = values().associateBy { it.exposureName }

        fun valueOf(name: String): Product = PRODUCT_MAP[name] ?: throw IllegalArgumentException("상품이 없습니다.")
    }
}
