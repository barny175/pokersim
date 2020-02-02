package cz.barny.pokersim.engine.hands

import cz.barny.pokersim.engine.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ThreeSetKtTest {

    @Test
    fun threeSet() {
        val communityCards: CommunityCards = CommunityCards(listOf(
            Card(Rank.ACE, Suit.Club),
            Card(Rank.TEN, Suit.Club),
            Card(Rank.THREE, Suit.Diamond),
            Card(Rank.THREE, Suit.Club),
            Card(Rank.JACK, Suit.Club)
        ))

        val hand: Hand = Hand(Card(Rank.QUEEN, Suit.Diamond), Card(Rank.THREE, Suit.Spade))

        val result = isThreeSet(hand, communityCards)
        Assertions.assertThat(result?.cards)
            .containsExactlyInAnyOrder(
                Card(Rank.THREE, Suit.Club),
                Card(Rank.THREE, Suit.Spade),
                Card(Rank.THREE, Suit.Diamond),
                Card(Rank.ACE, Suit.Club),
                Card(Rank.QUEEN, Suit.Diamond)
            )
    }
}