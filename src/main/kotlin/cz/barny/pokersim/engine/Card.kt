package cz.barny.pokersim.engine

class Card(val rank: Rank, val suit: Suit) {
    override fun toString(): String {
        return "Card(rank=$rank, suit=$suit)"
    }
}