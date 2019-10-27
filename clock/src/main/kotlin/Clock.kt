data class Clock(var hours: Int, var minutes: Int) {

    init {
        adjustTime()
    }

    override fun toString(): String {

        val hh = when {
            hours == 0 -> "00"
            hours < 10 -> "0$hours"
            else -> "$hours"
        }

        val mm = when {
            minutes == 0 -> "00"
            minutes < 10 -> "0$minutes"
            else -> "$minutes"
        }

        return "$hh:$mm"
    }

    fun add(m: Int) {
        this.minutes = minutes + m
        adjustTime()
    }

    fun subtract(m: Int) {
        this.minutes = minutes - m
        adjustTime()
    }

    private fun adjustTime() {
        if (minutes >= 60) {
            hours += minutes / 60
            minutes %= 60
        }

        while (minutes < 0) {
            hours--
            minutes += 60
        }

        if (hours >= 24) {
            hours %= 24
        }

        while (hours < 0) {
            hours += 24
        }
    }
}



