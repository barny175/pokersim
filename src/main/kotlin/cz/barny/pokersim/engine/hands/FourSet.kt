package cz.barny.pokersim.engine.hands

import cz.barny.pokersim.engine.Card
import cz.barny.pokersim.engine.CommunityCards
import cz.barny.pokersim.engine.Hand

class FourSet(cards: List<Card>) : Result(cards) {
    override fun order(): Int = 7
}

fun isFourSet(hand: Hand, communityCards: CommunityCards): ThreeSet? {
    val allCards = allCards(communityCards, hand)
    val ranks = getSets(allCards)
        .filter { it.size >= 4 }

    if (ranks.isEmpty())
        return null

    val fourSet = ranks.last()
    val res = resultCards(allCards, fourSet)
    return ThreeSet(res)
}