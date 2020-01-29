package cz.barny.pokersim.engine

import cz.barny.pokersim.engine.hands.isStraight
import org.assertj.core.api.Assertions.assertThat

internal class StraightKtTest {

    @org.junit.jupiter.api.Test
    fun straightWithLowerAce() {
        val communityCards: CommunityCards = CommunityCards(listOf(
            Card(Rank.ACE, Suit.Club),
            Card(Rank.TEN, Suit.Club),
            Card(Rank.FOUR, Suit.Diamond),
            Card(Rank.FIVE, Suit.Club),
            Card(Rank.QUEEN, Suit.Club)
        ))

        val hand: Hand = Hand(Card(Rank.TWO, Suit.Diamond), Card(Rank.THREE, Suit.Spade))

        val result = isStraight(hand, communityCards)
        assertThat(result)
            .extracting({ c -> c!!.getHighestCard() })
            .isEqualTo(Rank.FIVE)
    }

    @org.junit.jupiter.api.Test
    fun straightWithHigherAce() {
        val communityCards: CommunityCards = CommunityCards(listOf(
            Card(Rank.ACE, Suit.Club),
            Card(Rank.TEN, Suit.Club),
            Card(Rank.FOUR, Suit.Diamond),
            Card(Rank.FIVE, Suit.Club),
            Card(Rank.QUEEN, Suit.Club)
        ))

        val hand: Hand = Hand(Card(Rank.JACK, Suit.Diamond), Card(Rank.KING, Suit.Spade))

        val result = isStraight(hand, communityCards)
        assertThat(result)
            .extracting({ c -> c!!.getHighestCard() })
            .isEqualTo(Rank.ACE)
    }

    @org.junit.jupiter.api.Test
    fun noStraight() {
        val communityCards: CommunityCards = CommunityCards(listOf(
            Card(Rank.SEVEN, Suit.Spade),
            Card(Rank.TEN, Suit.Club),
            Card(Rank.QUEEN, Suit.Club),
            Card(Rank.FIVE, Suit.Club),
            Card(Rank.QUEEN, Suit.Diamond)
        ))

        val hand: Hand = Hand(Card(Rank.SIX, Suit.Diamond), Card(Rank.NINE, Suit.Spade))

        val result = isStraight(hand, communityCards)
        assertThat(result)
            .isNull()
    }
}