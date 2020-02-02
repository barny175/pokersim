package cz.barny.pokersim.engine.hands

import cz.barny.pokersim.engine.*
import org.assertj.core.api.Assertions.assertThat
import cz.barny.pokersim.engine.Suit.*

internal class StraightKtTest {

    @org.junit.jupiter.api.Test
    fun straightWithLowerAce() {
        val communityCards: CommunityCards = CommunityCards(listOf(
            Card(Rank.ACE, Club),
            Card(Rank.TEN, Club),
            Card(Rank.FOUR, Diamond),
            Card(Rank.FIVE, Club),
            Card(Rank.QUEEN, Club)
        ))

        val hand: Hand = Hand(Card(Rank.TWO, Diamond), Card(Rank.THREE, Spade))

        val result = isStraight(hand, communityCards)
        assertThat(result)
            .extracting({ c -> c!!.getHighestCard() })
            .isEqualTo(Rank.FIVE)
    }

    @org.junit.jupiter.api.Test
    fun straightWithHigherAce() {
        val communityCards: CommunityCards = CommunityCards(listOf(
            Card(Rank.ACE, Club),
            Card(Rank.TEN, Club),
            Card(Rank.FOUR, Diamond),
            Card(Rank.FIVE, Club),
            Card(Rank.QUEEN, Club)
        ))

        val hand: Hand = Hand(Card(Rank.JACK, Diamond), Card(Rank.KING, Spade))

        val result = isStraight(hand, communityCards)
        assertThat(result)
            .extracting({ c -> c!!.getHighestCard() })
            .isEqualTo(Rank.ACE)
    }

    @org.junit.jupiter.api.Test
    fun noStraight() {
        val communityCards: CommunityCards = CommunityCards(listOf(
            Card(Rank.SEVEN, Spade),
            Card(Rank.TEN, Club),
            Card(Rank.QUEEN, Club),
            Card(Rank.FIVE, Club),
            Card(Rank.QUEEN, Diamond)
        ))

        val hand: Hand = Hand(Card(Rank.SIX, Diamond), Card(Rank.NINE, Spade))

        val result = isStraight(hand, communityCards)
        assertThat(result)
            .isNull()
    }
}