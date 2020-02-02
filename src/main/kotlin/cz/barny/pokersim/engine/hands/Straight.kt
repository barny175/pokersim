package cz.barny.pokersim.engine.hands

import cz.barny.pokersim.engine.*

class Straight(cards: List<Card>) : Result(cards) {
    override fun order(): Int = 4
}

fun isStraight(hand: Hand, communityCards: CommunityCards): Straight? {
    val allCards = allCards(communityCards, hand)
    return isStraight(allCards)
}

fun isStraight(allCards: List<Card>): Straight? {
    val cards = allCards.flatMap { c -> c.rank.values().map { value -> Pair(value, c) } }
        .sortedBy { p -> p.first }
        .distinctBy { it.first }

    for (i in cards.size downTo 5) {
        val high = i - 1
        val low = i - 1 - 4
        if (cards[high].first - cards[low].first == 4) {
            return Straight(
                cards.subList(
                    low,
                    high + 1
                ).map { p -> p.second })
        }
    }
    return null
}