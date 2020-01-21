package cz.barny.pokersim.engine

enum class Rank {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(1, 14);

    private val values: MutableList<Int> = mutableListOf()

    constructor(i : Int) {
        values.add(i)
    }

    constructor(i: Int, j: Int) {
        values.add(i)
        values.add(j)
    }

    fun values(): List<Int> {
        return values
    }
}