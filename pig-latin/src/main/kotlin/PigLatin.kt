object PigLatin {

    // single vowels or combinations that are considered vowals: "yt" and "xr"
    private val singleVowelsAndFriends = "^([aeiou]|yt|xr).*".toRegex()

    // three-letter combinations that are treated like a single consonant: "thr", "sch" or a consonant before "qu"
    private val threeLetterCombinationsTreatedLikeSingleConsonant = "^(thr|sch|[bcdfghjklmnpqrstvwxyz]qu).*".toRegex()

    // two-letter combinations that are treated like a single consonant: "ch", "qu", "th" or two consonants before a "y"
    private val twoLetterCombinationsTreatedLikeSingleConsonant = "^(ch|qu|th|[bcdfghjklmnpqrstvwxyz]{2,}y).*".toRegex()

    fun translate(input: String): String = input
            .split(" ")
            .joinToString(" ") { aLotOfRegexMagic(it) + "ay" }

    private fun aLotOfRegexMagic(it: String): String {
        return when {
            // single vowels are not moved
            it.matches(singleVowelsAndFriends) -> it

            // three-letter combinations, treated like single consonants, are moved to the end
            it.matches(threeLetterCombinationsTreatedLikeSingleConsonant) -> it.rotate(3)

            // two-letter combinations, treated like single consonants, are moved to the end
            it.matches(twoLetterCombinationsTreatedLikeSingleConsonant) -> it.rotate(2)

            // single consonants are moved to the end
            else -> it.rotate(1)
        }
    }
}

private fun String.rotate(count: Int) = this.drop(count) + this.take(count)
