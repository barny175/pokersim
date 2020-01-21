package cz.barny.pokersim.engine

import java.util.*
import java.util.stream.Collectors

class HandComparator(val communityCards: CommunityCards) {
    fun compare(hand1: Hand, hand2: Hand): Int {
        return 0
    }

    private fun pickBest(hand: Hand): Result? {
        var result: Result? = isStraight(hand, communityCards)
        return result
    }
}