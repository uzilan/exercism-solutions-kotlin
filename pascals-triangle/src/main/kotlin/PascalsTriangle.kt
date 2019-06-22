object PascalsTriangle {
    fun computeTriangle(rowCount: Int,
                        currentRowIndex: Int = 1,
                        rows: List<List<Int>> = emptyList()): List<List<Int>> {
        require(rowCount >= 0) { "Rows can't be negative!" }
        if (currentRowIndex > rowCount) return rows
        val previousRow = if (currentRowIndex == 1) listOf(1) else rows[currentRowIndex - 2]
        val row = listOf(getRow(currentRowIndex, previousRow))
        return computeTriangle(rowCount, currentRowIndex + 1, rows + row)
    }

    private fun getRow(length: Int, previousRow: List<Int>): List<Int> {
        return (0 until length).map {
            left(it, previousRow) + right(it, previousRow)
        }
    }

    private fun left(index: Int, previousRow: List<Int>): Int {
        return if (index == 0) 0
        else previousRow[index - 1]
    }

    private fun right(index: Int, previousRow: List<Int>): Int {
        return if (index == previousRow.size) 0
        else previousRow[index]
    }
}

