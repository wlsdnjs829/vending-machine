package com.example.vending_machine.view

import com.example.vending_machine.bag.Wallet
import com.example.vending_machine.bag.currency.Cash
import com.example.vending_machine.bag.currency.Coin
import com.example.vending_machine.bag.currency.Currency
import com.example.vending_machine.view.model.MoneyCommand
import com.example.vending_machine.view.model.PlayCommand

object InputView {

    private const val DELIMITER: Char = ','

    fun createWallet(): Wallet {
        println(message = "'룰루 얼마를 들고갈까?' (cash, coin)")
        val inputText = readln()

        return Wallet(
            cash = Cash(
                amount = inputText.substringBefore(delimiter = DELIMITER)
                    .trim()
                    .toInt(),
            ),

            coin = Coin(
                amount = inputText.substringAfterLast(delimiter = DELIMITER)
                    .trim()
                    .toInt(),
            ),
        )
    }

    fun useMachine(): PlayCommand {
        println(message = "\n자판기를 이용하시겠습니까? (y, n)")
        return PlayCommand.valueOf(command = readln())
    }

    fun insertMoney(): Currency {
        println(message = "\n돈을 넣어주세요(지폐일 경우 cash, 동전일 경우 coin 입력 후 개수 입력)")
        val inputText = readln()


        return MoneyCommand.valueOf(
            command = inputText.substringBefore(delimiter = DELIMITER).trim(),
        ).toCurrency(
            amount = inputText.substringAfterLast(delimiter = DELIMITER)
                .trim()
                .toInt(),
        )
    }

    fun continueInsertMoney(): PlayCommand {
        println(message = "\n계속 넣으시겠습니까? (y, n)")
        return PlayCommand.valueOf(command = readln())
    }
}
