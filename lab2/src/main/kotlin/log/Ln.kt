package main.kotlin.log

import main.kotlin.Fun
import kotlin.math.abs
import kotlin.math.pow

open class Ln(
        accuracy: Double
) : Fun (accuracy){
    private val ln2 = this(2.0)
    private val ln1000 = this(1000.0)


    override fun invoke(x: Double): Double {
        if (accuracy <= 0.0 || x < 0.0)
            throw IllegalArgumentException("Accuracy should be positive")
        if (x - 0.0 == 0.0)
            return Double.NEGATIVE_INFINITY



        val tailor = {n:Int ->
            ((x-1)/(x+1)).pow(n) * (1.0/n)
        }

//        if (x > 2) return this(x / 2.0) + ln2
//        if (x < 0.7) return this(x * 1000.0) - ln1000
        var result = 0.0
        var current = 10.0
        var prev = 0.0
        var n = 1
        while (abs(prev - current) >= accuracy) {
            prev = current
            current = tailor(n)
            result += current
            n+=2
        }
        return 2 * result
    }
}
