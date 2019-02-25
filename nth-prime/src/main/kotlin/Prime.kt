object Prime {
    fun nth(i: Int): Int {
        require(i > 0) { "There is no zeroth prime." }

        var current = 0
        generateSequence(2, Int::inc).forEach {
            if (isPrime(it))
                if (++current == i)
                    return it
        }
        throw IllegalArgumentException()
    }
}

fun isPrime(i: Int) = (2 until i).none { i.rem(it) == 0 }