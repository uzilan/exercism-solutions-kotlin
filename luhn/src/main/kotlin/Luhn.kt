object Luhn {
    fun isValid(number: String): Boolean {
        val noSpaces = number.replace(" ", "")
        if (noSpaces.length <= 1 || noSpaces.toIntOrNull() == null) return false

        val summed = noSpaces.reversed().mapIndexed { index, char ->
            if ((index + 1) % 2 != 0) char.toString().toInt()
            else {
                val doubled = char.toString().toInt() * 2
                if (doubled > 9) doubled - 9 else doubled
            }
        }.sum()
        return summed % 10 == 0
    }
}