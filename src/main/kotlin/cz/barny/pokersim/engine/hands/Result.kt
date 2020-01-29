package cz.barny.pokersim.engine.hands

import cz.barny.pokersim.engine.Card
import cz.barny.pokersim.engine.CommunityCards
import cz.barny.pokersim.engine.Hand
import cz.barny.pokersim.engine.Rank

abstract class Result(val cards: List<Card>) {
    init {
        if (cards.size != 5)
            throw IllegalArgumentException("There must be 5 cards.")
    }

    fun getHighestCard(): Rank = cards[cards.size - 1].rank
}

fun allCards(
    communityCards: CommunityCards,
    hand: Hand
): MutableList<Card> {
    val allCards = mutableListOf<Card>()
    allCards.addAll(communityCards.cards)
    allCards.add(hand.card1)
    allCards.add(hand.card2)
    return allCards
}