fun <T> List<T>.relationshipTo(other: List<T>): Relationship {
    return when {
        this == other -> Relationship.EQUAL
        this.isSublistOf(other) -> Relationship.SUBLIST
        this.isSuperlistOf(other) -> Relationship.SUPERLIST
        else -> Relationship.UNEQUAL
    }
}

private fun <T> List<T>.isSublistOf(other: List<T>): Boolean {
    if (this.size > other.size) return false
    return (0..other.size).any {
        if (it + this.size > other.size) false
        else this == other.subList(it, it + this.size)
    }
}

private fun <T> List<T>.isSuperlistOf(other: List<T>): Boolean {
    return other.reversed().isSublistOf(this.reversed())
}
