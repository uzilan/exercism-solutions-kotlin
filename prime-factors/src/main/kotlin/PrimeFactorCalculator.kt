object PrimeFactorCalculator {

    fun primeFactors(number: Int): List<Int> {
        return primeFactors(number.toLong()).map { it.toInt() }
    }

    fun primeFactors(number: Long): List<Long> {
        val lowestPrime = (2L..number).find { number.rem(it) == 0L }

        lowestPrime?.let {
            return listOf(lowestPrime) + primeFactors(number / lowestPrime)
        } ?: return emptyList()
    }
}
