import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(birthTime: LocalDateTime) {
    constructor(birthDate: LocalDate) : this(birthDate.atStartOfDay())

    val date: LocalDateTime = birthTime.plusSeconds(1E9.toLong())
}