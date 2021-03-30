package main.kotlin.system

import main.kotlin.Fun

open class SystemFun(
        accuracy: Double,
        private val firstFun: FirstFun = FirstFun(accuracy),
        private val secondFun: SecondFun = SecondFun(accuracy)
) : Fun (accuracy){
    override fun invoke(x: Double): Double =
        if(x <= 0) firstFun(x) else secondFun(x)

}
