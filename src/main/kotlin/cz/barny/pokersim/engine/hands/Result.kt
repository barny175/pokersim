package cz.barny.pokersim.engine.hands

import cz.barny.pokersim.engine.*
import java.util.stream.Collectors

abstract class Result(val cards: List<Card>) {
    init {
        if (cards.size != 5)
            throw IllegalArgumentException("There must be 5 cards.")
    }

    fun getHighestCard(): Rank = cards[cards.size - 1].rank
}

fun allCards(
    communityCards: CommunityCards,
    hand: Hand
): MutableList<Card> {
    val allCards = mutableListOf<Card>()
    allCards.addAll(communityCards.cards)
    allCards.add(hand.card1)
    allCards.add(hand.card2)
    allCards.sortBy { it.rank.highestValue() }
    return allCards
}


fun groupBySuit(
    communityCards: CommunityCards,
    hand: Hand
): Map<Suit, MutableList<Card>> {
    val suits = allCards(communityCards, hand).stream()
        .collect(Collectors.groupingBy(Card::suit))
    return suits
}