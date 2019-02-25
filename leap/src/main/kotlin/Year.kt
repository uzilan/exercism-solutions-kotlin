class Year(year: Int) {
    val isLeap: Boolean = when {
        year.rem(400) == 0 -> true
        year.rem(100) == 0 -> false
        year.rem(4) == 0 -> true
        else -> false
    }
}
