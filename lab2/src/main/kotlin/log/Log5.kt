package main.kotlin.log

import main.kotlin.Fun

open class Log5(
        accuracy: Double,
        private val ln: Ln = Ln(accuracy),
) : Fun(accuracy) {
    private val ln5 = ln(5.0)
    override fun invoke(x: Double): Double = ln(x) / ln5
}
