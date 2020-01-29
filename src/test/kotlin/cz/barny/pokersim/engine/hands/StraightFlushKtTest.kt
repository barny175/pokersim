package cz.barny.pokersim.engine.hands

import cz.barny.pokersim.engine.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class StraightFlushKtTest {

    @Test
    fun isStraightFlush() {
        val communityCards: CommunityCards = CommunityCards(listOf(
            Card(Rank.ACE, Suit.Club),
            Card(Rank.TEN, Suit.Club),
            Card(Rank.FOUR, Suit.Diamond),
            Card(Rank.JACK, Suit.Club),
            Card(Rank.QUEEN, Suit.Club)
        ))

        val hand: Hand = Hand(Card(Rank.KING, Suit.Club), Card(Rank.THREE, Suit.Spade))

        val result = isStraightFlush(hand, communityCards)
        Assertions.assertThat(result)
            .isInstanceOf(StraightFlush::class.java)
            .extracting({ c -> c!!.getHighestCard() })
            .isEqualTo(Rank.ACE)
    }

    @Test
    fun moreStraightsWithOneLowerStraightFlush() {
        val communityCards: CommunityCards = CommunityCards(listOf(
            Card(Rank.ACE, Suit.Heart),
            Card(Rank.TEN, Suit.Club),
            Card(Rank.FOUR, Suit.Diamond),
            Card(Rank.JACK, Suit.Club),
            Card(Rank.QUEEN, Suit.Club)
        ))

        val hand: Hand = Hand(Card(Rank.KING, Suit.Club), Card(Rank.NINE, Suit.Club))

        val result = isStraightFlush(hand, communityCards)
        Assertions.assertThat(result)
            .isInstanceOf(StraightFlush::class.java)
            .extracting({ c -> c!!.getHighestCard() })
            .isEqualTo(Rank.KING)
    }
}