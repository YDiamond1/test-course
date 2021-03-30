package main.kotlin.system

import main.kotlin.Fun
import main.kotlin.log.*
import java.lang.IllegalArgumentException
import kotlin.math.pow

open class SecondFun (accuracy: Double,
                      private val ln: Ln = Ln(accuracy),
                      private val log2: Log2 = Log2(accuracy),
                      private val log5: Log5 = Log5(accuracy),
                      private val log3: Log3 = Log3(accuracy),
                      private val log10: Log10 = Log10(accuracy)
): Fun(accuracy) {
    override fun invoke(x: Double): Double {
        if(x == 1.0) throw IllegalArgumentException("Divided by zero")
        return ((log5(x) + log10(x))/ln(x) - log3(x)).pow(3) - log2(x)/log2(x)
    }
}
