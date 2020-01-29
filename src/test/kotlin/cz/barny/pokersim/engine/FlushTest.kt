package cz.barny.pokersim.engine

import cz.barny.pokersim.engine.hands.isFlush
import org.assertj.core.api.Assertions

internal class FlushTest {

    @org.junit.jupiter.api.Test
    fun flush() {
        val communityCards: CommunityCards = CommunityCards(listOf(
            Card(Rank.ACE, Suit.Club),
            Card(Rank.TEN, Suit.Club),
            Card(Rank.FOUR, Suit.Diamond),
            Card(Rank.FIVE, Suit.Club),
            Card(Rank.QUEEN, Suit.Club)
        ))

        val hand: Hand = Hand(Card(Rank.TWO, Suit.Club), Card(Rank.THREE, Suit.Spade))

        val result = isFlush(hand, communityCards)
        Assertions.assertThat(result)
            .extracting({ c -> c!!.getHighestCard() })
            .isEqualTo(Rank.ACE)
    }


    @org.junit.jupiter.api.Test
    fun noFlush() {
        val communityCards: CommunityCards = CommunityCards(listOf(
            Card(Rank.ACE, Suit.Club),
            Card(Rank.TEN, Suit.Heart),
            Card(Rank.FOUR, Suit.Diamond),
            Card(Rank.FIVE, Suit.Club),
            Card(Rank.QUEEN, Suit.Club)
        ))

        val hand: Hand = Hand(Card(Rank.TWO, Suit.Club), Card(Rank.THREE, Suit.Spade))

        val result = isFlush(hand, communityCards)
        Assertions.assertThat(result)
            .isNull()
    }
}