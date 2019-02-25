class School {
    private val db = mutableMapOf<Int, MutableList<String>>()
    fun db(): Map<Int, List<String>> = db.toMap()

    fun grade(i: Int) = db[i]?.toList() ?: emptyList()

    fun add(s: String, i: Int) {
        db.getOrPut(i, { mutableListOf() })
                .add(s)
    }

    fun sort(): Map<Int, List<String>> = db
            .toSortedMap()
            .mapValues {
                it.value?.toSortedSet()?.toList() ?: emptyList()
            }
}
