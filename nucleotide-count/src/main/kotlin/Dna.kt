class Dna(dna: String) {
    init {
        require("^[ACGT]*$".toRegex().matches(dna))
    }

    val nucleotideCounts = "ACGT".map { it to 0 }.toMap() +
            dna.groupingBy { it }.eachCount()
}
