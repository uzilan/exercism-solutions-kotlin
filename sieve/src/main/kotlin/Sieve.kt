object Sieve {
    fun primesUpTo(limit: Int): List<Int> {
        var list = (2..limit).toList()

        return list.fold(emptyList()) { acc, _ ->
            if (list.isEmpty()) acc
            else {
                val ret = list.first()
                list = list.filter {
                    it % list.first() != 0
                }
                acc + ret
            }
        }
    }
}