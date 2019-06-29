object Series {
    fun slices(digits: Int, input: String): List<List<Int>> {
        return input
                .windowed(digits)
                .map {
                    it.toList().map(Character::getNumericValue)
                }
    }
}
