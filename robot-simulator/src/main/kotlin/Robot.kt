import Orientation.EAST
import Orientation.NORTH
import Orientation.SOUTH
import Orientation.WEST

class Robot(gridPosition: GridPosition = GridPosition(0, 0),
            orientation: Orientation = NORTH) {

    var gridPosition = gridPosition
        private set

    var orientation = orientation
        private set

    fun turnRight() {
        orientation = when (orientation) {
            NORTH -> EAST
            EAST -> SOUTH
            SOUTH -> WEST
            WEST -> NORTH
        }
    }

    fun turnLeft() {
        orientation = when (orientation) {
            NORTH -> WEST
            WEST -> SOUTH
            SOUTH -> EAST
            EAST -> NORTH
        }
    }

    fun advance() {
        val x = gridPosition.x
        val y = gridPosition.y

        gridPosition = when (orientation) {
            NORTH -> GridPosition(x, y + 1)
            EAST -> GridPosition(x + 1, y)
            SOUTH -> GridPosition(x, y - 1)
            WEST -> GridPosition(x - 1, y)
        }
    }

    fun simulate(instructions: String) {
        instructions.forEach {
            when (it) {
                'L' -> turnLeft()
                'R' -> turnRight()
                'A' -> advance()
            }
        }
    }
}
