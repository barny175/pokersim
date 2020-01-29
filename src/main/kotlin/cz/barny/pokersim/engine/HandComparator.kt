package cz.barny.pokersim.engine

import cz.barny.pokersim.engine.hands.Result
import cz.barny.pokersim.engine.hands.isFlush
import cz.barny.pokersim.engine.hands.isStraight
import cz.barny.pokersim.engine.hands.isStraightFlush

class HandComparator(val communityCards: CommunityCards) {
    fun compare(hand1: Hand, hand2: Hand): Int {
        return 0
    }
}

fun pickBest(hand: Hand, communityCards: CommunityCards): Result? {
    var result: Result? = isStraightFlush(hand, communityCards)
    if (result != null) {
        return result
    }

    result = isStraight(hand, communityCards)
    if (result != null) {
        return result
    }

    result = isFlush(hand, communityCards)
    return result
}