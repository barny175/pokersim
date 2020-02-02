package cz.barny.pokersim.engine.hands

import cz.barny.pokersim.engine.Card
import cz.barny.pokersim.engine.CommunityCards
import cz.barny.pokersim.engine.Hand
import java.util.stream.Collectors

class Pair(cards: List<Card>) : Result(cards) {

}

fun isPair(hand: Hand, communityCards: CommunityCards): Pair? {
    val allCards = allCards(communityCards, hand)
    val ranks = allCards.stream()
        .collect(Collectors.groupingBy(Card::rank))
        .filter { it.value.size >= 2 }
        .map { it.value }
        .sortedBy { it.first().rank.highestValue() }
    if (ranks.isEmpty())
        null

    val highestPair = ranks.last()
    highestPair.take(2)
        .forEach { allCards.remove(it) }

    val res = mutableListOf<Card>()
    res.addAll(highestPair.take(2))
    res.addAll(allCards.reversed().take(3))
    return Pair(res)
}