package main.kotlin.trig

import main.kotlin.Fun
import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

open class Cos
(
    accuracy: Double,
    private val sin: Sin = Sin(accuracy)
) : Fun(accuracy)
{
    override fun invoke(x: Double): Double {
        var pi_x = x % (2*PI)
        if(pi_x < 0) pi_x+=2*PI
        pi_x = if(pi_x > PI/2 && pi_x < 3 * PI /2) -1.0 else 1.0

        val pow = sin(x).pow(2)
        return pi_x * sqrt(1- pow)
    }

}
