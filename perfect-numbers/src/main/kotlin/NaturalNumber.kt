enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    require(naturalNumber > 0) { RuntimeException("$naturalNumber is less than or equals to 0") }
    val aliqoutSum = factors(naturalNumber).sum()
    return when {
        aliqoutSum > naturalNumber -> Classification.ABUNDANT
        aliqoutSum < naturalNumber -> Classification.DEFICIENT
        else -> Classification.PERFECT
    }
}

fun factors(num: Int): List<Int> = (1..num / 2).filter { num % it == 0 }