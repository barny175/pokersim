package cz.barny.pokersim.engine.hands

import cz.barny.pokersim.engine.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TwoPairsKtTest {

    @Test
    fun twoPairs() {
        val communityCards: CommunityCards = CommunityCards(listOf(
            Card(Rank.ACE, Suit.Club),
            Card(Rank.TEN, Suit.Club),
            Card(Rank.FOUR, Suit.Diamond),
            Card(Rank.THREE, Suit.Club),
            Card(Rank.QUEEN, Suit.Club)
        ))

        val hand: Hand = Hand(Card(Rank.ACE, Suit.Diamond), Card(Rank.THREE, Suit.Spade))

        val result = isTwoPairs(hand, communityCards)
        Assertions.assertThat(result?.cards)
            .containsExactlyInAnyOrder(
                Card(Rank.THREE, Suit.Club),
                Card(Rank.THREE, Suit.Spade),
                Card(Rank.ACE, Suit.Club),
                Card(Rank.ACE, Suit.Diamond),
                Card(Rank.QUEEN, Suit.Club)
            )
    }

    @Test
    fun threePairs() {
        val communityCards: CommunityCards = CommunityCards(listOf(
            Card(Rank.ACE, Suit.Club),
            Card(Rank.QUEEN, Suit.Heart),
            Card(Rank.FOUR, Suit.Diamond),
            Card(Rank.THREE, Suit.Club),
            Card(Rank.QUEEN, Suit.Club)
        ))

        val hand: Hand = Hand(Card(Rank.ACE, Suit.Diamond), Card(Rank.THREE, Suit.Spade))

        val result = isTwoPairs(hand, communityCards)
        Assertions.assertThat(result?.cards)
            .containsExactlyInAnyOrder(
                Card(Rank.QUEEN, Suit.Heart),
                Card(Rank.FOUR, Suit.Diamond),
                Card(Rank.ACE, Suit.Club),
                Card(Rank.ACE, Suit.Diamond),
                Card(Rank.QUEEN, Suit.Club)
            )
    }

}