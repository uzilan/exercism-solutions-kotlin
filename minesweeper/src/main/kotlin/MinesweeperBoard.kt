class MinesweeperBoard(private val inputBoard: List<String>) {

    fun withNumbers(): List<String> {
        return inputBoard
                .mapIndexed { rowIndex, row ->
                    row.mapIndexed { colIndex, col ->
                        findCellContent(rowIndex, colIndex)
                    }.joinToString("")
                }
    }

    private fun findCellContent(rowIndex: Int, colIndex: Int): String {
        if (isThereABombAt(rowIndex, colIndex)) {
            return "*"
        }
        val bombCount = lookAround(rowIndex, colIndex)
        return if (bombCount == 0) " " else "" + bombCount
    }

    private fun lookAround(rowIndex: Int, colIndex: Int): Int {
        return (rowIndex - 1..rowIndex + 1)
                .sumBy { row ->
                    (colIndex - 1..colIndex + 1)
                            .sumBy { col ->
                                lookAtNeighbour(rowIndex, colIndex, row, col)
                            }
                }
    }

    private fun lookAtNeighbour(rowIndex: Int, colIndex: Int, neighbourRow: Int, neighbourCol: Int): Int {
        return when {
            neighbourRow == rowIndex && neighbourCol == colIndex -> 0
            isThereABombAt(neighbourRow, neighbourCol) -> 1
            else -> 0
        }
    }

    private fun isThereABombAt(rowIndex: Int, colIndex: Int): Boolean {
        return when {
            rowIndex < 0 || rowIndex >= inputBoard.size || colIndex < 0 || colIndex >= inputBoard[0].length -> false
            else -> inputBoard[rowIndex][colIndex] == '*'
        }
    }
}
