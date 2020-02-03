package cz.barny.pokersim.engine

import cz.barny.pokersim.engine.hands.*

class HandComparator(val communityCards: CommunityCards) {
    fun compare(hand1: Hand, hand2: Hand): Int {
        val best1 = pickBest(hand1, communityCards)
        val best2 = pickBest(hand2, communityCards)

        val res = best1.order().compareTo(best2.order())
        if (res == 0) {
            val zip = best1.cards.reversed()
                .zip(best2.cards.reversed(),
                    { c1, c2 -> c1.rank.highestValue().compareTo(c2.rank.highestValue()) })
            val res = zip.find { it != 0 }
            return if (res == null) 0 else res
        }
        return res
    }
}

fun pickBest(hand: Hand, communityCards: CommunityCards): Result {
    var result: Result? = isStraightFlush(hand, communityCards)
    if (result != null) {
        return result
    }

    result = isFourSet(hand, communityCards)
    if (result != null) {
        return result
    }

    result = isFullHouse(hand, communityCards)
    if (result != null) {
        return result
    }

    result = isFlush(hand, communityCards)
    if (result != null) {
        return result
    }

    result = isStraight(hand, communityCards)
    if (result != null) {
        return result
    }

    result = isThreeSet(hand, communityCards)
    if (result != null) {
        return result
    }

    result = isTwoPairs(hand, communityCards)
    if (result != null) {
        return result
    }

    val pair = isPair(hand, communityCards)
    if (result != null) {
        return result
    }

    return isHighCard(hand, communityCards)
}