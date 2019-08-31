object Raindrops {
    fun convert(input: Int): String {
        val strings = listOf(3, 5, 7)
                .filter { input % it == 0 }
                .map {
                    when (it) {
                        3 -> "Pling"
                        5 -> "Plang"
                        7 -> "Plong"
                        else -> ""
                    }
                }
        return if (strings.isEmpty()) input.toString()
        else strings.joinToString("")
    }
}