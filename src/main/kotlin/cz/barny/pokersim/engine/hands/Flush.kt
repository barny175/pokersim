package cz.barny.pokersim.engine.hands

import cz.barny.pokersim.engine.*
import java.util.stream.Collectors

class Flush(cards: List<Card>) : Result(cards) {

}

fun isFlush(hand: Hand, communityCards: CommunityCards): Flush? {
    val suits = allCards(communityCards, hand).stream()
        .collect(Collectors.groupingBy(Card::suit))
    val flushCards = suits
        .filter { cards -> cards.value.size >= 5 }
        .map { it.value }
        .firstOrNull()
    sortCards(flushCards)
    return if (flushCards != null) Flush(flushCards) else null
}

private fun sortCards(flushCards: MutableList<Card>?) {
    flushCards?.sortBy { it.rank.highestValue() }
}