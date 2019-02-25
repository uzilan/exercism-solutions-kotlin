object Hamming {
    fun compute(s1: String, s2: String): Int {
        if (s1.length != s2.length) throw IllegalArgumentException("left and right strands must be of equal length.")
        return s1.zip(s2).count { it.first != it.second }
    }
}