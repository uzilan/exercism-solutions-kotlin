class Squares(val number: Int) {
    fun squareOfSum1(): Int = (1..number).sum().square()

    fun squareOfSum(): Int = ((number * (number + 1)) / 2).square()

    fun sumOfSquares1(): Int = (1..number).sumBy { it.square() }

    fun sumOfSquares(): Int = (number * (number + 1) * (2 * number + 1)) / 6

    fun difference(): Int = squareOfSum() - sumOfSquares()

    private fun Int.square(): Int = this * this
}