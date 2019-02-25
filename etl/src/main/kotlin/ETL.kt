object ETL {
    fun transform(old: Map<Int, List<Char>>): Map<Char, Int> =
            old.flatMap { (number, list) ->
                list.map { it.toLowerCase() to number }
            }.toMap()
}
