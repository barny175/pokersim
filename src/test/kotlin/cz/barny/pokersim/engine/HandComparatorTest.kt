package cz.barny.pokersim.engine

internal class HandComparatorTest {

    @org.junit.jupiter.api.Test
    fun straight() {
        val communityCards: CommunityCards = CommunityCards(listOf(
            Card(Rank.ACE, Suit.Club),
            Card(Rank.TEN, Suit.Club),
            Card(Rank.FOUR, Suit.Club),
            Card(Rank.FIVE, Suit.Club),
            Card(Rank.QUEEN, Suit.Club)
            ))


    }
}