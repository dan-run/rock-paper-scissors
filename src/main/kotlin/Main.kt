import classes.Game
import classes.RandomPlayer
import classes.RockPlayer
import enums.SetResult

const val defaultRuns = 100

fun main(args: Array<String>) {
    val runs = if (args.isNotEmpty()) {
        try {
            args[0].toInt()
        } catch (e: NumberFormatException) {
            println("Bad input, running 100 times instead of ${args[0]}.")
            defaultRuns
        }
    } else defaultRuns

    val game = Game(RandomPlayer(), RockPlayer())

    // integers in triplets are not mutable :(
    var accOne = 0
    var accTwo = 0
    var accThree = 0

    repeat(runs) {
        when (game.play()) {
            SetResult.PLAYER_ONE -> accOne += 1
            SetResult.PLAYER_TWO -> accTwo += 1
            SetResult.DRAW -> accThree += 1
        }
    }

    val playerOnePercent = "%.1f".format((accOne.toDouble() / runs.toDouble()) * 100)
    val playerTwoPercent = "%.1f".format((accTwo.toDouble() / runs.toDouble()) * 100)

    val line = if (accOne > accTwo) "${game.playerOne} wins total."
    else if (accTwo > accOne) "${game.playerTwo} wins total."
    else "It's a draw!"

    println("${game.playerOne}: $accOne wins. ${game.playerTwo}: $accTwo wins. $accThree draws.")
    println("$line ${game.playerOne} won $playerOnePercent%. ${game.playerTwo} won $playerTwoPercent%")
}