package main.kotlin.trig

import main.kotlin.Fun
import java.lang.IllegalArgumentException
import kotlin.math.PI

open class Csc(
        accuracy: Double,
        private val sin: Sin = Sin(accuracy)
) : Fun(accuracy) {
    override fun invoke(x: Double): Double {
        if(x % PI == 0.0)
            throw IllegalArgumentException ("Division by zero")
        return 1.0/sin(x)
    }

}
