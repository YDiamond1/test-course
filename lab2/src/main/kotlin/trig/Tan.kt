package main.kotlin.trig

import main.kotlin.Fun
import java.lang.IllegalArgumentException
import kotlin.math.PI

open class Tan(
        accuracy: Double,
        private val sin: Sin = Sin(accuracy),
        private val cos: Cos = Cos(accuracy)
) : Fun(accuracy) {
    override fun invoke(x: Double): Double {
        if(x % (PI/2) == 0.0 && x % PI != 0.0)
            throw IllegalArgumentException("Divided by zero")
        return sin(x)/cos(x)
    }
}
