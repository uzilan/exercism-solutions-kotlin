import NumberSpeller.Scale.Companion.getScale
import NumberSpeller.Scale.TRILLION

class NumberSpeller {

    fun say(number: Long): String {
        require(number >= 0) { "Input must be non-negative" }
        require(number < TRILLION.scale) { "Input must be less than 1000000000000" }

        return when (number) {
            0L -> "zero"
            in 1L..9L -> ones(number)
            in 10L..99L -> tenToNinetyNine(number)
            else -> hundredAndAbove(number)
        }
    }

    private fun ones(number: Long, suffix: String? = null): String {
        return if (suffix == null) when (number) {
            1L -> "one"
            2L -> "two"
            3L -> "three"
            4L -> "four"
            5L -> "five"
            6L -> "six"
            7L -> "seven"
            8L -> "eight"
            9L -> "nine"
            else -> ""
        } else when (number) {
            2L -> "twen"
            3L -> "thir"
            4L -> if (suffix == "teen") "four" else "for"
            5L -> "fif"
            6L -> "six"
            7L -> "seven"
            8L -> "eigh"
            9L -> "nine"
            else -> ""
        } + suffix
    }

    private fun tenToNinetyNine(number: Long) = when (number) {
        10L -> "ten"
        11L -> "eleven"
        12L -> "twelve"
        in 13L..19L -> ones(number - 10, "teen")
        in 20L..99L -> {
            val tens = ones(number / 10, "ty")
            val ones = ones(number % 10)
            tens + if (ones.isEmpty()) "" else "-$ones"
        }
        else -> ""
    }

    private fun hundredAndAbove(number: Long): String {
        val scale = getScale(number)
        val prefix = say(number / scale.scale)
        val rest = number % scale.scale
        val restAsString = if (rest > 0) " ${say(rest)}" else ""
        return "$prefix $scale$restAsString"
    }

    private enum class Scale(val scale: Long) {
        HUNDRED(100),
        THOUSAND(1_000),
        MILLION(1_000_000),
        BILLION(1_000_000_000),
        TRILLION(1_000_000_000_000),
        ZILLION(Long.MAX_VALUE);

        companion object {
            fun getScale(number: Long) = when (number.toString().length) {
                3 -> HUNDRED
                in 4..6 -> THOUSAND
                in 7..9 -> MILLION
                in 10..12 -> BILLION
                in 13..15 -> TRILLION
                else -> ZILLION
            }
        }

        override fun toString(): String {
            return name.toLowerCase()
        }
    }
}
