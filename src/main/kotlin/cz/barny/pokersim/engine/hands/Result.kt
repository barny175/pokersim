package cz.barny.pokersim.engine.hands

import cz.barny.pokersim.engine.*
import java.util.stream.Collectors

abstract class Result(val cards: List<Card>) {
    init {
        if (cards.size != 5)
            throw IllegalArgumentException("There must be exactly 5 cards. Found " + cards.size)
    }

    fun getHighestCard(): Rank = cards[cards.size - 1].rank

    abstract fun order(): Int
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

fun resultCards(
    allCards: MutableList<Card>,
    vararg twoSets: MutableList<Card>?
): MutableList<Card> {
    val res = mutableListOf<Card>()
    var rest = allCards
    twoSets.forEach { twoSet ->
        res.addAll(twoSet!!)
        rest.removeAll(twoSet)
    }
    rest.sortBy { it.rank }
    val complete = 5 - res.size
    res.addAll(rest.takeLast(complete))
    return res
}