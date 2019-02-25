import java.math.BigInteger
import java.math.BigInteger.ONE

object Board {
    private val TWO = 2.toBigInteger()

    fun getGrainCountForSquare(i: Int): BigInteger {
        require(i in 1..64) { "Only integers between 1 and 64 (inclusive) are allowed" }
        return TWO.pow(i - 1)
    }

    fun getTotalGrainCount(): BigInteger {
        return TWO.pow(64) - ONE
    }
}