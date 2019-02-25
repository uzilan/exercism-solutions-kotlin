import java.util.Stack

object BracketPush {

    fun isValid(input: String): Boolean {
        return helper(input, Stack())
    }

    fun helper(input: String, stack: Stack<Char>): Boolean {
        if (input.isEmpty()) return stack.isEmpty()

        val firstChar = input[0]

        if (listOf('(', '[', '{').contains(firstChar)) {
            stack.push(firstChar)
            return helper(input.drop(1), stack)
        }

        if (listOf(')', ']', '}').contains(firstChar) && stack.isEmpty()) {
            return false
        }

        val ok = when (firstChar) {
            ')' -> '(' == stack.pop()
            ']' -> '[' == stack.pop()
            '}' -> '{' == stack.pop()
            else -> true
        }

        return ok && helper(input.drop(1), stack)
    }
}
