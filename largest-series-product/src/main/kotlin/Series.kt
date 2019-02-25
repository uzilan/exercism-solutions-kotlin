class Series(private val s: String) {
    init {
        require(s.isEmpty() || s.all { it.isDigit() })
    }

    fun getLargestProduct(num: Int): Long {
        require(num >= 0 && num <= s.length)
        require((s.isNotEmpty() || num == 0))
        if (num == 0) return 1

        return (0..s.length - num)
                .map {
                    s.substring(it, it + num)
                            .map { it.toString().toLong() }
                            .reduce { acc, i -> acc * i }
                }.max()!!
    }
}