object Pangram {
    fun isPangram(text: String): Boolean =
            ('a'..'z').all { text.contains(it, true) }
}