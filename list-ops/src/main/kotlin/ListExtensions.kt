tailrec fun <T> List<T>.customAppend(list: List<T>): List<T> {
    return when {
        list.isEmpty() -> this
        else -> (this + list.first()).customAppend(list.drop(1))
    }
}

fun List<Any?>.customConcat(): List<Any?> {
    return when {
        this.isEmpty() -> this
        else -> {
            val first = this.first()
            when (first) {
                is List<Any?> -> first.customConcat()
                else -> listOf(first)
            } + this.drop(1).customConcat()
        }
    }
}

fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T> {
    return when {
        this.isEmpty() -> this
        else -> {
            val first = this.first()
            when (predicate(first)) {
                true -> listOf(first)
                false -> emptyList()
            } + this.drop(1).customFilter(predicate)
        }
    }
}

val <T> List<T>.customSize: Int
    get() {
        return when {
            this.isEmpty() -> 0
            else -> 1 + drop(1).customSize
        }
    }

fun <T, R> List<T>.customMap(transform: (T) -> R): List<R> {
    return when {
        this.isEmpty() -> emptyList()
        else -> listOf(transform(this.first())) + this.drop(1).customMap(transform)
    }
}

tailrec fun <T, R> List<T>.customFoldLeft(initial: R, operation: (R, T) -> R): R {
    return when {
        this.isEmpty() -> initial
        else -> this.drop(1).customFoldLeft(operation(initial, this.first()), operation)
    }
}

tailrec fun <T, R> List<T>.customFoldRight(initial: R, operation: (T, R) -> R): R {
    return when {
        this.isEmpty() -> initial
        else -> this.dropLast(1).customFoldRight(operation(this.last(), initial), operation)
    }
}

fun <T> List<T>.customReverse(): List<T> {
    return when {
        this.isEmpty() -> this
        else -> listOf(this.last()) + this.dropLast(1).customReverse()
    }
}