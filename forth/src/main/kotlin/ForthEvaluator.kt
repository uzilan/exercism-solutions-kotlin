import java.util.Stack

class ForthEvaluator {

    private val queue = Stack<Int>()
    private val userDefinedOperators = mutableMapOf<String, List<String>>()

    fun evaluateProgram(input: List<String>): List<Int> {
        input.forEach {
            when {
                it.startsWith(":") -> parseUserDefinedOperator(it)
                else -> parseOperators(it.split(" "))
            }
        }
        return queue.toList()
    }

    private fun parseOperators(operations: List<String>) {
        operations.forEach {
            val value = it.toIntOrNull()
            when (value) {
                null -> parseOperator(it)
                else -> queue.push(value)
            }
        }
    }

    private fun parseOperator(operator: String) {
        val lowerCaseOperator = operator.toLowerCase()
        if (userDefinedOperators.containsKey(lowerCaseOperator)) {
            runUserDefinedOperator(lowerCaseOperator)
        } else {
            when (lowerCaseOperator) {
                "+" -> add()
                "-" -> subtract()
                "*" -> multiply()
                "/" -> divide()
                "dup" -> duplicate()
                "drop" -> drop()
                "swap" -> swap()
                "over" -> over()
                else -> throw IllegalArgumentException("No definition available for operator \"$operator\"")
            }
        }
    }

    private fun add() {
        requireNumberOfValues("Addition", 2)
        queue.push(queue.pop() + queue.pop())
    }


    private fun subtract() {
        requireNumberOfValues("Subtraction", 2)
        val subtrahend = queue.pop()
        val minuend = queue.pop()
        queue.push(minuend - subtrahend)
    }

    private fun multiply() {
        requireNumberOfValues("Multiplication", 2)
        queue.push(queue.pop() * queue.pop())
    }

    private fun divide() {
        requireNumberOfValues("Division", 2)
        val denominator = queue.pop()
        require(denominator != 0) { "Division by 0 is not allowed" }
        val numerator = queue.pop()
        queue.push(numerator / denominator)
    }

    private fun duplicate() {
        requireNumberOfValues("Duplicating", 1)
        queue.push(queue.peek())
    }

    private fun drop() {
        requireNumberOfValues("Dropping", 1)
        queue.pop()
    }

    private fun swap() {
        requireNumberOfValues("Swapping", 2)
        val last = queue.pop()
        val lastButOne = queue.pop()
        queue.push(last)
        queue.push(lastButOne)
    }

    private fun over() {
        requireNumberOfValues("Overing", 2)
        val last = queue.pop()
        val lastButOne = queue.peek()
        queue.push(last)
        queue.push(lastButOne)
    }

    private fun requireNumberOfValues(operation: String, number: Int) {
        require(queue.size >= number) {
            val maybePlural = if (number == 1) "" else "s"
            "$operation requires that the stack contain at least $number value$maybePlural"
        }
    }

    private fun parseUserDefinedOperator(definition: String) {
        val split = definition.split(" ")
        val userDefinedOperator = split[1].toLowerCase()
        require(userDefinedOperator.toIntOrNull() == null) { "Cannot redefine numbers" }
        val operators = split.subList(2, split.size - 1)
        userDefinedOperators[userDefinedOperator] = operators
    }

    private fun runUserDefinedOperator(operator: String) {
        userDefinedOperators[operator]?.let { parseOperators(it) }
    }
}
