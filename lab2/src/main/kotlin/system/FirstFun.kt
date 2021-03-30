package main.kotlin.system

import main.kotlin.Fun
import main.kotlin.trig.Cot
import main.kotlin.trig.Csc
import main.kotlin.trig.Sin
import main.kotlin.trig.Tan
import kotlin.math.pow

open class FirstFun(
        accuracy: Double,
        private val cot: Cot = Cot(accuracy),
        private val tan: Tan = Tan(accuracy),
        private val csc: Csc = Csc(accuracy),
        private val sin: Sin = Sin(accuracy),
        ) : Fun(accuracy){
    override fun invoke(x: Double): Double {
        return ((cot(x).pow(2) + tan(x))/sin(x)).pow(2) - (csc(x) - tan(x).pow(2)).pow(2)
    }

}
