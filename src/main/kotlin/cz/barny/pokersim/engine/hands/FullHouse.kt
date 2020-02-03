package cz.barny.pokersim.engine.hands

import cz.barny.pokersim.engine.Card
import cz.barny.pokersim.engine.CommunityCards
import cz.barny.pokersim.engine.Hand

class FullHouse(cards: List<Card>) : Result(cards) {
    override fun order(): Int = 6
}

fun isFullHouse(hand: Hand, communityCards: CommunityCards): FullHouse? {
    val allCards = allCards(communityCards, hand)
    val ranks = getSets(allCards)

    if (ranks.size < 2)
        null

    val threeSet = ranks.findLast { it.size >= 3 }
    if (threeSet == null) {
        return null
    }
    val withouThreeSet = ranks.filter { it != threeSet }

    val twoSet = withouThreeSet.findLast { it.size >= 2 }
    if  (twoSet == null) {
        return null
    }

    val res = resultCards(allCards, twoSet.take(2), threeSet)
    return FullHouse(res)
}
