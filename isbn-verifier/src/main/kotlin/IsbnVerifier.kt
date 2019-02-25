class IsbnVerifier {
    fun isValid(s: String): Boolean {
        val noHyphens = s.replace("-", "")
        val indexOfX = noHyphens.indexOf('X')
        if (noHyphens.contains("[^0-9|X]".toRegex()) ||
                (indexOfX > -1 && indexOfX < 9) ||
                noHyphens.length != 10) return false
        val sum = noHyphens
                .map { if (it == 'X') 10 else it.toString().toInt() }
                .zip((1..10).reversed())
                .map { it.first * it.second }
                .sum()
        return sum.rem(11) == 0
    }
}
