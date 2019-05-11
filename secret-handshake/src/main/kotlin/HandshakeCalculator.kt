object HandshakeCalculator {
    fun calculateHandshake(num: Int): List<Signal> {
        val arr = ArrayList<Signal>()
        if (num and 0b1 == 0b1) arr.add(Signal.WINK)
        if (num and 0b10 == 0b10) arr.add(Signal.DOUBLE_BLINK)
        if (num and 0b100 == 0b100) arr.add(Signal.CLOSE_YOUR_EYES)
        if (num and 0b1000 == 0b1000) arr.add(Signal.JUMP)
        if (num and 0b10000 == 0b10000) arr.reverse()
        return arr
    }   
}