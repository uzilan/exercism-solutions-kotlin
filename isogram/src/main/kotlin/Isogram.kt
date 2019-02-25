object Isogram {
    fun isIsogram(input: String): Boolean = input
            .filter { it.isLetter() }
            .none { char ->
                input.count {
                    it.equals(char, true)
                } > 1
            }
}
