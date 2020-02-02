package cz.barny.pokersim.engine.hands

import cz.barny.pokersim.engine.*
import org.assertj.core.api.Assertions.assertThat
import cz.barny.pokersim.engine.Suit.*
import java.util.function.Function

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
        assertThat(result!!.cards)
            .containsExactlyInAnyOrder(
                Card(Rank.ACE, Club),
                Card(Rank.TWO, Diamond),
                Card(Rank.THREE, Spade),
                Card(Rank.FOUR, Diamond),
                Card(Rank.FIVE, Club)
            )
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
        assertThat(result!!.cards)
            .containsExactlyInAnyOrder(
                Card(Rank.TEN, Club),
                Card(Rank.JACK, Diamond),
                Card(Rank.QUEEN, Club),
                Card(Rank.KING, Spade),
                Card(Rank.ACE, Club)
            )
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

    @org.junit.jupiter.api.Test
    fun straightWithPair() {
        val communityCards: CommunityCards = CommunityCards(listOf(
            Card(Rank.NINE, Club),
            Card(Rank.TEN, Club),
            Card(Rank.TEN, Diamond),
            Card(Rank.FIVE, Club),
            Card(Rank.QUEEN, Club)
        ))

        val hand: Hand = Hand(Card(Rank.JACK, Diamond), Card(Rank.KING, Spade))

        val result = isStraight(hand, communityCards)
        assertThat(result)
            .extracting({ c -> c!!.getHighestCard() })
            .isEqualTo(Rank.KING)
        assertThat(result!!.cards)
            .extracting("rank")
            .containsExactlyInAnyOrder(
                Rank.NINE,
                Rank.TEN,
                Rank.JACK,
                Rank.QUEEN,
                Rank.KING
            )
    }
}