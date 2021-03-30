package main.kotlin.trig

import main.kotlin.Fun
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.pow

open class Sin(accuracy: Double) : Fun(accuracy * 0.001) {
    private var cache : Pair<Double, Double> = Pair(Double.NaN, Double.NaN);

    private fun fact(num: Int): Long =
            if (num == 1) 1 else fact(num - 1) * num

    private fun shortenRange(x: Double): Double {
        return if (x > PI || x < -PI) {
            val k = x % (2 * PI)
            when {
                k < -PI -> k + 2 * PI
                k > PI -> k - 2 * PI
                else -> k
            }
        } else
            x
    }

    override fun invoke(x: Double): Double {
        val sx = shortenRange(x)
        if(sx == cache.first) return cache.second
        if (accuracy <= 0)
            throw IllegalArgumentException("Accuracy should be positive")
        if(sx % (PI/2) == 0.0  && sx % PI != 0.0) return 1.0
        if(sx % (-PI/2) == 0.0 && sx % PI != 0.0) return -1.0

        val tailor = { n: Int ->
            ((-1.0).pow(n) * sx.pow(2 * n + 1)) / fact(2 * n + 1) }
        var result = 0.0
        var current = 10.0
        var prev = 0.0
        var n = 0
        while (abs(prev - current) >= accuracy) {
            prev = current
            current = tailor(n)
            result += current
            n++
        }
        cache = Pair(sx, result)
        return result
    }
}
