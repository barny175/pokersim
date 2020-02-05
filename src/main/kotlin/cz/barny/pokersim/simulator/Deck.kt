package cz.barny.pokersim.simulator

import cz.barny.pokersim.engine.Card
import cz.barny.pokersim.engine.Hand
import cz.barny.pokersim.engine.Rank
import cz.barny.pokersim.engine.Suit
import kotlin.random.Random

class Deck {
    private val random: Random = Random(System.currentTimeMillis())
    private val deck: MutableList<Card> = generateDeck()

    private fun generateDeck(): MutableList<Card> {
        return Rank.values()
            .flatMap { rank ->
                Suit.values().map { suit -> Card(rank, suit) }
            }
            .toMutableList()
    }

    fun deal(): Card {
        if (deck.isEmpty()) {
            throw IllegalStateException("Deck is empty")
        }
        val card = random.nextInt(deck.size)
        return deck.removeAt(card)
    }
}