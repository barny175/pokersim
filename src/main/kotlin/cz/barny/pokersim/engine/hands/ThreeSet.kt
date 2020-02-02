package cz.barny.pokersim.engine.hands

import cz.barny.pokersim.engine.Card
import cz.barny.pokersim.engine.CommunityCards
import cz.barny.pokersim.engine.Hand

class ThreeSet(cards: List<Card>) : Result(cards) {
    override fun order(): Int = 4
}

fun isThreeSet(hand: Hand, communityCards: CommunityCards): ThreeSet? {
    val allCards = allCards(communityCards, hand)
    val ranks = getSets(allCards)
        .filter { it.size >= 3 }

    if (ranks.isEmpty())
        return null

    val threeset = ranks.last()
    val res = resultCards(allCards, threeset)
    return ThreeSet(res)
}