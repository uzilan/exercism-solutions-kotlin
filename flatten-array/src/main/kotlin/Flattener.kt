object Flattener {
    fun flatten(list: List<*>): List<Any> {
        return list.fold(emptyList()) { acc, item ->
            when (item) {
                is List<*> -> acc + flatten(item)
                null -> acc
                else -> acc + item
            }
        }
    }
}
