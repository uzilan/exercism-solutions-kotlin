object HandshakeCalculator {
    private const val REVERSED = 0b10000

    fun calculateHandshake(num: Int): List<Signal> {
        return Signal.values()
                .filter { num and it.value == it.value }
                .apply { return if (num and REVERSED == REVERSED) reversed() else this }
    }
}