package enums

import classes.Winner

enum class Choice : Winner<Choice> {
    ROCK {
        override fun winsAgainst(other: Choice): Boolean = other == SCISSORS
    },
    PAPER {
        override fun winsAgainst(other: Choice): Boolean = other == ROCK
    },
    SCISSORS {
        override fun winsAgainst(other: Choice): Boolean = other == PAPER
    }
}
