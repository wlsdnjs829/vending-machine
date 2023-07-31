package com.example.vending_machine.buyer

import com.example.vending_machine.buyer.bag.Wallet
import com.example.vending_machine.buyer.event.CurrencyStateEvent
import com.example.vending_machine.buyer.event.InsertCurrencyEvent
import com.example.vending_machine.buyer.event.PurchaseEvent
import com.example.vending_machine.buyer.event.SituationEvent
import com.example.vending_machine.machine.VendingMachine

class Buyer(
    private val wallet: Wallet,
    private val vendingMachine: VendingMachine,
    private val currencyStateEvent: CurrencyStateEvent,
) {

    fun currentState() {
        currencyStateEvent.currentCurrencyEvent(
            WalletInfo(
                cashAmount = wallet.cashAmount(),
                coinAmount = wallet.coinAmount(),
                monetaryAmount = wallet.monetaryAmount(),
            ),
        )

        currencyStateEvent.machineChangesEvent(
            VendingMachineInfo(
                changes = vendingMachine.changes()
            ),
        )
    }

    tailrec fun useMachine(
        insertCurrencyEvent: InsertCurrencyEvent,
        purchaseEvent: PurchaseEvent,
        situationEvent: SituationEvent,
    ): Boolean = if (insertCurrencyEvent.useMachineEvent()) {
        vendingMachine.insertCurrency(
            inputCurrencyEvent = insertCurrencyEvent.inputCurrencyEvent,
            takeOutCurrencyEvent = { currency -> wallet.takeOutCurrency(currency = currency) },
            continueEvent = insertCurrencyEvent.continueEvent,
        )

        vendingMachine.purchase(
            purchaseEvent = purchaseEvent,
            situationEvent = situationEvent,
            putInCoinEvent = { coin -> wallet.putInCoin(coin = coin) },
        )

        currentState()

        useMachine(
            insertCurrencyEvent = insertCurrencyEvent,
            purchaseEvent = purchaseEvent,
            situationEvent = situationEvent,
        )
    } else {
        purchaseEvent.getChangesEvent()
            .takeIf { it }
            ?.apply { wallet.putInCoin(coin = vendingMachine.takeOutCoin()) }
            ?: false
    }
}

class WalletInfo(val cashAmount: Int, val coinAmount: Int, val monetaryAmount: Int)

@JvmInline
value class VendingMachineInfo(val changes: Int)

