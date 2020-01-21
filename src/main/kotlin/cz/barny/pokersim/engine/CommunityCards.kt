package cz.barny.pokersim.engine

class CommunityCards(val cards: List<Card>) {
    init {
        if (cards.size != 5) {
            throw IllegalArgumentException("There can be just 5 community cards.")
        }
    }
}