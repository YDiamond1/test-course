package main.kotlin

abstract class Fun(
        val accuracy: Double = 1e-5
)
{
    abstract operator fun invoke(x:Double): Double
}
