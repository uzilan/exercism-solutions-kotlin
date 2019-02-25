object Raindrops {
    fun convert(num: Int): String = buildString {
        if (num.rem(3) == 0) append("Pling")
        if (num.rem(5) == 0) append("Plang")
        if (num.rem(7) == 0) append("Plong")
        if (isEmpty()) append(num)
    }
}