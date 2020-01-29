package cz.barny.pokersim.engine.hands

import cz.barny.pokersim.engine.*
import java.util.stream.Collectors

class StraightFlush(cards: List<Card>) : Result(cards) {

}

fun isStraightFlush(hand: Hand, communityCards: CommunityCards): StraightFlush? {
    val suits = allCards(communityCards, hand).stream()
        .collect(Collectors.groupingBy(Card::suit))

    val straight = suits.values.map { isStraight(it) }
        .firstOrNull()
    return if (straight != null)
        StraightFlush(straight.cards)
    else
        null
}