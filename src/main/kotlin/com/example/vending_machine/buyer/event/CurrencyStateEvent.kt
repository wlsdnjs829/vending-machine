package com.example.vending_machine.buyer.event

import com.example.vending_machine.buyer.VendingMachineInfo
import com.example.vending_machine.buyer.WalletInfo
import com.example.vending_machine.view.ResultView

class CurrencyStateEvent(
    val currentCurrencyEvent: (WalletInfo) -> Unit = { walletInfo ->
        ResultView.printCurrentCurrency(info = walletInfo)
    },

    val machineChangesEvent: (VendingMachineInfo) -> Unit = { vendingMachineInfo ->
        ResultView.printMachineChanges(info = vendingMachineInfo)
    },
)
