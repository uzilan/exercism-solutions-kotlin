class Anagram(private val detector: String) {
    fun match(candidates: List<String>): Set<String> {
        return candidates.filter { detector.isAnagramOf(it) }.toSet()
    }
}

private fun String.isAnagramOf(word: String): Boolean {
    if (this.toLowerCase() == word.toLowerCase()) return false
    if (this.isAllUpperCase() != word.isAllUpperCase()) return false
    return this.toSortedString() == word.toSortedString()
}

private fun String.isAllUpperCase() = this.asIterable().all { it.isUpperCase() }
private fun String.toSortedString() = this.toLowerCase().asIterable().sorted().toString()

