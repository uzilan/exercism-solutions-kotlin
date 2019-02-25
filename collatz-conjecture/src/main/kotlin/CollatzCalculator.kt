object CollatzCalculator {
    fun computeStepCount(n: Int): Int {
        require(n > 0) { "Only natural numbers are allowed" }
        return helper(n, 0)
    }

    private fun helper(n: Int, counter: Int): Int {
        if (n == 1) return counter
        val temp = if (n.rem(2) == 0) n / 2 else n * 3 + 1
        return helper(temp, counter + 1)
    }
}