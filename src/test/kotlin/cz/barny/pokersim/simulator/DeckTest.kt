package cz.barny.pokersim.simulator

import cz.barny.pokersim.engine.Card
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DeckTest {

    @Test
    fun deal() {
        val game = Deck()
        val cards = mutableListOf<Card>()
        for (i in 0 until 52) {
            cards.add(game.deal())
        }
        val grouped = cards.groupBy { c -> c.suit }
    }


    @Test
    fun tryToDealMoreThanDeck() {
        val game = Deck()
        for (i in 0 until 52) {
            game.deal()
        }
        try {
            game.deal()
            fail<Any>("Exception expected")
        } catch (ex: IllegalStateException) {

        }
    }
}