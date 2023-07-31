package com.example.vending_machine.buyer.event

import com.example.vending_machine.machine.product.Product
import com.example.vending_machine.view.ResultView

class SituationEvent(
    val purchaseSoundEvent: () -> Unit = { ResultView.printPurchaseSound() },
    val notAvailableForPurchaseEvent: () -> Unit = { ResultView.printNotAvailableForPurchase() },
)
