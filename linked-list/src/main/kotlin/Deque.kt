class Deque<T> {
    private var first: Node<T> = Node()
    private var last: Node<T> = Node()

    fun push(value: T) {
        if (last.isEmpty()) {
            last = Node(value)
            first = last
        } else {
            val node = Node(value, previous = last)
            last.next = node
            last = node
        }
    }

    fun pop(): T? {
        if (last.isEmpty()) return null

        val value = last.value
        last = last.previous ?: Node()
        return value
    }

    fun unshift(value: T) {
        if (first.isEmpty()) {
            first = Node(value)
            last = first
        } else {
            val node = Node(value, next = first)
            first.previous = node
            first = node
        }
    }

    fun shift(): T? {
        if (first.isEmpty()) return null

        val value = first.value
        first = first.next ?: Node()
        return value
    }

    private data class Node<T>(val value: T? = null, var previous: Node<T>? = null, var next: Node<T>? = null) {
        fun isEmpty() = value == null
    }
}
