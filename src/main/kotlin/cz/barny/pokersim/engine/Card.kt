package cz.barny.pokersim.engine

data class Card(val rank: Rank, val suit: Suit) : Comparable<Card> {
    override fun compareTo(other: Card): Int {
        return other.rank.compareTo(this.rank)
    }
}