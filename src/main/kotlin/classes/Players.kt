package classes

import enums.Choice

abstract class Player constructor(private val choicePicker: () -> Choice, val name: String) {
    fun choose(): Choice = choicePicker.invoke()
    override fun toString(): String = name
}

class RandomPlayer : Player({ Choice.values().random() }, "Random player")
class RockPlayer : Player({ Choice.ROCK }, "Rock player")

