object Acronym {
    fun generate(phrase: String): String =
            phrase.split(" ", "-")
                    .map { it.first() }
                    .joinToString("")
                    .toUpperCase()
}