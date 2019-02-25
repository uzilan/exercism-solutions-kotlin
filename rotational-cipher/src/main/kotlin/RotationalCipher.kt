class RotationalCipher(count: Int) {
    private val plain = 'a'..'z'
    private val cypher = plain.drop(count) + plain.take(count)

    fun encode(s: String): String {
        return s.map { encodeChar(it) }.joinToString("")
    }

    private fun encodeChar(char: Char): Char {
        val index = plain.indexOf(char.toLowerCase())
        return when {
            !char.isLetter() -> char
            char.isUpperCase() -> cypher[index].toUpperCase()
            else -> cypher[index]
        }
    }
}

