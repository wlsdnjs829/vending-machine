package com.example.vending_machine.bag

import com.example.vending_machine.bag.currency.Cash
import com.example.vending_machine.bag.currency.Coin

data class Wallet(private val cash: Cash, private val coin: Coin)
