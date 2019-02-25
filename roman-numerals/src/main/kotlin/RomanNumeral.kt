object RomanNumeral {

    fun value(input: Int): String {
        return when {
            input > 1000 -> "M" + value(input - 1000)
            input > 100 -> roman(input / 100, "C", "D", "M") + value(input % 100)
            input > 10 -> roman(input / 10, "X", "L", "C") + value(input % 10)
            input >= 1 -> roman(input, "I", "V", "X")
            else -> ""
        }
    }

    fun roman(number: Int, one: String, five: String, ten: String): String {
        return when (number) {
            10 -> ten
            9 -> one + ten
            6, 7, 8 -> five + one.repeat(number - 5)
            5 -> five
            4 -> one + five
            1, 2, 3 -> one.repeat(number)
            else -> ""
        }
    }
}


