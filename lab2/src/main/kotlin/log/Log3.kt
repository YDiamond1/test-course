package main.kotlin.log

import main.kotlin.Fun

open class Log3(
        accuracy: Double,
        private val ln: Ln = Ln(accuracy),
) : Fun(accuracy) {
    private val ln3 = ln(3.0)
    override fun invoke(x: Double): Double = ln(x) / ln3
}
