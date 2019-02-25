class Matrix(val list: List<List<Int>>) {

    val saddlePoints =
            list.mapIndexed { rowIndex, row ->
                row.mapIndexed { columnIndex, num ->
                    if (largestInRow(num, row) && lowestInColumn(num, column(columnIndex)))
                        MatrixCoordinate(rowIndex, columnIndex)
                    else null
                }
            }.flatten().filterNotNull().toSet()

    private fun column(i: Int): List<Int> = list.map { it[i] }
    private fun largestInRow(num: Int, row: List<Int>) = row.all { num >= it }
    private fun lowestInColumn(num: Int, column: List<Int>) = column.all { num <= it }
}