object Acronym {
    fun generate(phrase: String): String =
            phrase.split(" ", "-")
                    .filter { it.isNotEmpty() }
                    .map { it.first() }
                    .joinToString("")
                    .toUpperCase()
}