package cz.barny.pokersim.engine.hands

import cz.barny.pokersim.engine.Card
import cz.barny.pokersim.engine.CommunityCards
import cz.barny.pokersim.engine.Hand

class TwoPairs(cards: List<Card>) : Result(cards) {
    override fun order(): Int = 2
}

fun isTwoPairs(hand: Hand, communityCards: CommunityCards): TwoPairs? {
    val allCards = allCards(communityCards, hand)
    val ranks = getSets(allCards)
    if (ranks.size <= 1)
        null

    val res = mutableListOf<Card>()
    val pairCards = ranks.takeLast(2).flatMap { it.take(2) }
    res.addAll(pairCards)

    allCards.removeAll(pairCards)
    res.add(allCards.last())

    return TwoPairs(res)
}