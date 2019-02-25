class Triangle(a: Double, b: Double, c: Double) {
    constructor(a: Int, b: Int, c: Int) : this(a.toDouble(), b.toDouble(), c.toDouble())

    private val distinctSides: Int

    init {
        val numberList = listOf(a, b, c)
        val max = numberList.max()
        if (max == null || max * 2 >= a + b + c) {
            throw IllegalArgumentException("There's something fishy about this triangle!")
        }
        distinctSides = numberList.distinct().count()
    }

    val isEquilateral = distinctSides == 1
    val isIsosceles = distinctSides <= 2
    val isScalene = distinctSides == 3
}