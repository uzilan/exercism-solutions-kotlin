object SumOfMultiples {
    fun sum(set: Set<Int>, limit: Int): Int =
            set.flatMap { multiplier -> findMultipliers(limit, multiplier) }.distinct().sum()

    private val findMultipliers = { limit: Int, multiplier: Int -> (1 until limit).filter { it % multiplier == 0 } }
}