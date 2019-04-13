object CollatzCalculator {
    fun computeStepCount(n: Int, counter: Int = 0): Int {
        require(n > 0) { "Only natural numbers are allowed" }
        if (n == 1) return counter
        val temp = if (n.rem(2) == 0) n / 2 else n * 3 + 1
        return computeStepCount(temp, counter + 1)
    }
}