object Bob {
    fun hey(s: String): String {
        val trimmed = s.trim()
        return when {
            trimmed.isEmpty() -> "Fine. Be that way!"
            trimmed.isUpperCase() -> "Whoa, chill out!"
            trimmed.endsWith("?") -> "Sure."
            else -> "Whatever."
        }
    }
}

private fun String.isUpperCase(): Boolean {
    val onlyLetters = this.replace("[^a-zA-Z]".toRegex(), "")
    return onlyLetters.matches("[A-Z]+".toRegex())
}