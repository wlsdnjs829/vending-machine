package com.example.vending_machine.buyer.event

import com.example.vending_machine.machine.product.Product
import com.example.vending_machine.view.InputView

class PurchaseEvent(
    val purchaseProductEvent: () -> Product = { InputView.purchaseProduct() },
    val getChangesEvent: () -> Boolean = { InputView.getChanges().isProgress() },
)
