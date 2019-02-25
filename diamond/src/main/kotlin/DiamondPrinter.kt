class DiamondPrinter {
    fun printToList(ch: Char): List<String>? {
        val strings = ('A'..ch).map {
            val outerSpace = (ch - it).spaces()
            if (it == 'A') "$outerSpace$it$outerSpace"
            else {
                val innerSpace = (2 * (it - 'A') - 1).spaces()
                "$outerSpace$it$innerSpace$it$outerSpace"
            }
        }
        return strings + strings.take(strings.size - 1).reversed()
    }
}

private fun Int.spaces(): String = (0 until this).joinToString("") { " " }
