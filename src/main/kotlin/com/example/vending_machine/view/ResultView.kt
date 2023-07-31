package com.example.vending_machine.view

import com.example.vending_machine.buyer.VendingMachineInfo
import com.example.vending_machine.buyer.WalletInfo

object ResultView {

    fun printCurrentCurrency(info: WalletInfo) = println(
        message = "\n현재 잔액: ${info.monetaryAmount}(cash - ${info.cashAmount}, coin - ${info.coinAmount})",
    )

    fun printMachineChanges(info: VendingMachineInfo) = println(
        message = "자판기 잔돈: ${info.changes}",
    )

    fun printPurchaseSound() = println(message = "\n'덜컹'")

    fun printNotAvailableForPurchase() = println(message = "\n'구매할 수 없습니다'")
}
