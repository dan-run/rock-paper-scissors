import classes.Game
import classes.RandomPlayer
import classes.RockPlayer
import enums.Choice
import enums.SetResult
import io.kotest.assertions.timing.eventually
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.property.forAll

class Tests : StringSpec({
    "Rock is rock" {
        val player = RockPlayer()
        player.choose() shouldBe Choice.ROCK
    }

    "Random is random" {
        val player = RandomPlayer()
        player.choose() shouldBeIn Choice.values()
    }

    "Rock and rock is draw" {
        val game = Game(RockPlayer(), RockPlayer())
        game.play() shouldBe SetResult.DRAW
    }

    "Rock and random is not draw" {
        val game = Game(RockPlayer(), RandomPlayer())
        // non-deterministic test since its random
        eventually {
            game.play() shouldNotBe SetResult.DRAW
        }
    }

    "Run the app with random args" {
        forAll<String> {
            main(arrayOf(it))
            true// property based context needs boolean return
        }
    }

    "Run the app without args" {
        main(arrayOf())
    }
})