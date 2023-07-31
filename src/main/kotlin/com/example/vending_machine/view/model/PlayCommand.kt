package com.example.vending_machine.view.model

enum class PlayCommand(private val command: String) {
    Y(command = "y"),
    N(command = "n"),
    ;

    fun isProgress(): Boolean = this == Y

    companion object {
        fun valueOf(command: String) = values().find { it.command == command }
            ?: throw IllegalArgumentException("허용되지 않은 명령어입니다. 입력값 : $command")
    }
}
