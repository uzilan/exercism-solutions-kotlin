class Robot {
    var name: String = ""

    companion object {
        val usedNames = mutableListOf<String>()
    }

    init {
        reset()
    }

    fun reset() {
        while (name.isEmpty() || usedNames.contains(name)) {
            name = randomizeName()
        }
        usedNames.add(name)
    }

    private fun randomizeName(): String {
        val letters = ('A'..'Z').random(2)
        val numbers = (0..9).random(3)
        return letters + numbers
    }

    private fun <T> Iterable<T>.random(count: Int): String {
        return (0 until count)
                .map { this.toList().shuffled()[0] }
                .joinToString("")
    }
}

