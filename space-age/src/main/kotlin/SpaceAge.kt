import kotlin.math.round

class SpaceAge(val ageInSeconds: Long) {
    private val secondsInEarthYear = 60 * 60 * 24 * OrbitalPeriod.Earth.value
    private fun roundToTwoDecimals(number: Double) = round(number * 100) / 100
    private fun calculate(orbitalPeriod: OrbitalPeriod): Double =
            roundToTwoDecimals(ageInSeconds / (orbitalPeriod.value * secondsInEarthYear))

    fun onEarth(): Double = roundToTwoDecimals(ageInSeconds / secondsInEarthYear)
    fun onMercury(): Double = calculate(OrbitalPeriod.Mercury)
    fun onVenus(): Double = calculate(OrbitalPeriod.Venus)
    fun onMars(): Double = calculate(OrbitalPeriod.Mars)
    fun onJupiter(): Double = calculate(OrbitalPeriod.Jupiter)
    fun onSaturn(): Double = calculate(OrbitalPeriod.Saturn)
    fun onUranus(): Double = calculate(OrbitalPeriod.Uranus)
    fun onNeptune(): Double = calculate(OrbitalPeriod.Neptune)
}

enum class OrbitalPeriod(val value: Double) {
    Earth(365.25),
    Mercury(0.2408467),
    Venus(0.61519726),
    Mars(1.8808158),
    Jupiter(11.862615),
    Saturn(29.447498),
    Uranus(84.016846),
    Neptune(164.79132)
}