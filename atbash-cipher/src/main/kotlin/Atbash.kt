object Atbash {

    private val map = ('a'..'z').zip('z' downTo 'a').toMap()

    fun encode(input: String): String = decode(input)
            .chunked(5)
            .joinToString(" ")

    fun decode(input: String): String = input.toLowerCase()
            .map {
                when {
                    it.isDigit() -> it
                    map.containsKey(it) -> map[it]
                    else -> ' '
                }
            }
            .joinToString("")
            .replace(" ", "")
}