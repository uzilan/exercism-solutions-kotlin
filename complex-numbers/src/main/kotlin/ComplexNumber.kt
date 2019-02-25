import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.sin
import kotlin.math.sqrt

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {
    override fun toString() = "$real + $imag * i"

    // absolute: |z| = sqrt(a^2 + b^2)
    val abs = sqrt(this.real.square() + this.imag.square())
}

// conjugate: a - b * i
fun ComplexNumber.conjugate(): ComplexNumber =
        ComplexNumber(this.real, this.imag * -1)

// addition: (a + i * b) + (c + i * d) = (a + c) + (b + d) * i
operator fun ComplexNumber.plus(other: ComplexNumber): ComplexNumber =
        ComplexNumber(this.real + other.real, this.imag + other.imag)

// substraction: (a + i * b) - (c + i * d) = (a - c) + (b - d) * i
operator fun ComplexNumber.minus(other: ComplexNumber): ComplexNumber =
        ComplexNumber(this.real - other.real, this.imag - other.imag)

// multiplication: (a + i * b) * (c + i * d) = (a * c - b * d) + (b * c + a * d) * i
operator fun ComplexNumber.times(other: ComplexNumber): ComplexNumber {
    val ac = this.real * other.real
    val bd = this.imag * other.imag
    val bc = this.imag * other.real
    val ad = this.real * other.imag
    return ComplexNumber(ac - bd, bc + ad)
}

// division: (a + i * b) / (c + i * d) = (a * c + b * d)/(c^2 + d^2) + (b * c - a * d)/(c^2 + d^2) * i
operator fun ComplexNumber.div(other: ComplexNumber): ComplexNumber {
    val ac = this.real * other.real
    val bd = this.imag * other.imag
    val bc = this.imag * other.real
    val ad = this.real * other.imag
    val denom = other.real.square() + other.imag.square()
    return ComplexNumber((ac + bd) / denom, (bc - ad) / denom)
}

// exponent: exp(a + i * b) = exp(a) * exp(i * b), where exp(i * b) = cos(b) + i * sin(b)
fun exponential(complex: ComplexNumber): ComplexNumber {
    val expa = exp(complex.real)
    val expb = ComplexNumber(cos(complex.imag), sin(complex.imag))
    return expa.toComplex() * expb
}

// double square
fun Double.square() = this * this

// double to complex
fun Double.toComplex(): ComplexNumber = ComplexNumber(real = this)