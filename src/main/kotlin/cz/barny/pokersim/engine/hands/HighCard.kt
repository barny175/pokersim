package cz.barny.pokersim.engine.hands

import cz.barny.pokersim.engine.Card
import cz.barny.pokersim.engine.CommunityCards
import cz.barny.pokersim.engine.Hand
import sun.security.ssl.HandshakeMessage

class HighCard(cards: List<Card>) : Result(cards) {
    override fun order(): Int = 0
}

fun isHighCard(hand: Hand, communityCards: CommunityCards): HighCard {
    return HighCard(allCards(communityCards, hand).takeLast(5))
}