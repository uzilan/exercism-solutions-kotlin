object BinarySearch {
    private const val NOT_FOUND = -1

    fun <T : Comparable<T>> search(list: List<T>, searchee: T): Int {
        val indexedList = list.mapIndexed { index, value -> IndexedValue(index, value) }
        return findInSubList(indexedList, searchee)
    }

    private tailrec fun <T : Comparable<T>> findInSubList(indexedList: List<IndexedValue<T>>, searchee: T): Int {
        if (indexedList.isEmpty()) return NOT_FOUND
        if (indexedList.size == 1 && indexedList[0].value != searchee) return NOT_FOUND

        val middleIndex = indexedList.size / 2
        val middle = indexedList[middleIndex]

        return when {
            middle.value == searchee -> middle.index
            searchee < middle.value -> findInSubList(indexedList.subList(0, middleIndex), searchee)
            else -> findInSubList(indexedList.subList(middleIndex, indexedList.size), searchee)
        }
    }
}
