package cz.barny.pokersim.engine

import cz.barny.pokersim.engine.hands.Flush
import org.assertj.core.api.Assertions.assertThat

internal class HandComparatorTest {

    @org.junit.jupiter.api.Test
    fun pickBestHand() {
        val communityCards: CommunityCards = CommunityCards(listOf(
            Card(Rank.ACE, Suit.Club),
            Card(Rank.TEN, Suit.Club),
            Card(Rank.FOUR, Suit.Club),
            Card(Rank.FIVE, Suit.Diamond),
            Card(Rank.QUEEN, Suit.Club)
            ))

        val hand: Hand = Hand(Card(Rank.NINE, Suit.Club), Card(Rank.KING, Suit.Heart))
        val best = pickBest(hand, communityCards)
        assertThat(best)
            .isInstanceOf(Flush::class.java)
    }

    @org.junit.jupiter.api.Test
    fun compare1() {
        val communityCards: CommunityCards = CommunityCards(listOf(
            Card(Rank.NINE, Suit.Club),
            Card(Rank.FIVE, Suit.Club),
            Card(Rank.EIGHT, Suit.Heart),
            Card(Rank.EIGHT, Suit.Club),
            Card(Rank.SIX, Suit.Club)
        ))

        val hand1: Hand = Hand(Card(Rank.TEN, Suit.Club), Card(Rank.FIVE, Suit.Diamond))
        val hand2: Hand = Hand(Card(Rank.ACE, Suit.Club), Card(Rank.NINE, Suit.Heart))
        val result = HandComparator(communityCards).compare(hand1, hand2)
        assertThat(result).isEqualTo(1)
    }
}