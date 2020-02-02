package cz.barny.pokersim.engine.hands

import cz.barny.pokersim.engine.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*

internal class HighCardKtTest {

    @org.junit.jupiter.api.Test
    fun fourSet() {
        val communityCards: CommunityCards = CommunityCards(listOf(
            Card(Rank.ACE, Suit.Spade),
            Card(Rank.TEN, Suit.Club),
            Card(Rank.THREE, Suit.Diamond),
            Card(Rank.TWO, Suit.Heart),
            Card(Rank.QUEEN, Suit.Club)
        ))

        val hand: Hand = Hand(Card(Rank.FIVE, Suit.Diamond), Card(Rank.NINE, Suit.Spade))

        val result = isHighCard(hand, communityCards)
        Assertions.assertThat(result?.cards)
            .containsExactlyInAnyOrder(
                Card(Rank.ACE, Suit.Spade),
                Card(Rank.QUEEN, Suit.Club),
                Card(Rank.TEN, Suit.Club),
                Card(Rank.NINE, Suit.Spade),
                Card(Rank.FIVE, Suit.Diamond)
            )
    }
}
