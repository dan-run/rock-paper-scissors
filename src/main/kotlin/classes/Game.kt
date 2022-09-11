package classes

import enums.SetResult

class Game constructor(val playerOne: Player, val playerTwo: Player) {
    fun play(): SetResult {
        val choiceOne = playerOne.choose()
        val choiceTwo = playerTwo.choose()

        return if (choiceOne.winsAgainst(choiceTwo)) {
            SetResult.PLAYER_ONE
        } else if (choiceTwo.winsAgainst(choiceOne)) {
            SetResult.PLAYER_TWO
        } else {
            SetResult.DRAW
        }
    }
}

