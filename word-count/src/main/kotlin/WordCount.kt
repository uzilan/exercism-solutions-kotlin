object WordCount {
    fun phrase(s: String): Map<String, Int> {
        val noPunctuation = "[!&@\\$%\\^&:\\n\\.,]".toRegex().replace(s, " ")
        val noQuotation = " '|' ".toRegex().replace(noPunctuation, " ")
        val noMultipleWhitespace = "\\s+".toRegex().replace(noQuotation, " ")
        val lowercased = noMultipleWhitespace.toLowerCase()
        val trimmed = lowercased.trim()
        val split = trimmed.split(" ")

        return split.groupingBy { it }.eachCount()
    }
}
