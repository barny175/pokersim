package cz.barny.pokersim.engine

import java.util.stream.Collectors

class Straight(val highestCard: Int) : Result {

}

fun isStraight(hand: Hand, communityCards: CommunityCards): Straight? {
    val allCards = mutableListOf<Card>()
    allCards.addAll(communityCards.cards)
    allCards.add(hand.card1)
    allCards.add(hand.card2)
    val cards = allCards.stream()
        .flatMap { c -> c.rank.values().stream() }
        .sorted()
        .collect(Collectors.toList())

    for (i in cards.size downTo 5) {
        if (cards[i - 1] - cards[i - 1 - 4] == 4) {
            return Straight(cards[i - 1])
        }
    }
    return null
}