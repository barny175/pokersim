package cz.barny.pokersim.engine.hands

import cz.barny.pokersim.engine.Card
import cz.barny.pokersim.engine.CommunityCards
import cz.barny.pokersim.engine.Hand

class FullHouse(cards: List<Card>) : Result(cards) {
}

fun isFullHouse(hand: Hand, communityCards: CommunityCards): FullHouse? {
    val allCards = allCards(communityCards, hand)
    val ranks = getSets(allCards)

    if (ranks.size <= 2)
        null

    val threeSet = ranks.findLast { it.size >= 3 }
    val twoSet = ranks.findLast { it.size == 2 }

    val res = resultCards(allCards, twoSet, threeSet)
    return FullHouse(res)
}
