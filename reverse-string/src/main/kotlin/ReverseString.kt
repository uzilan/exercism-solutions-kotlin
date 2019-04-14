tailrec fun reverse(input: String, accumulator: String = ""): String {
    return if (input.isEmpty()) accumulator
    else reverse(input.substring(1), input[0] + accumulator)
}
