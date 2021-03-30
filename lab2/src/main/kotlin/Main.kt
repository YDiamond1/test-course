package main.kotlin


import main.kotlin.log.*
import main.kotlin.system.FirstFun
import main.kotlin.trig.Sin
import java.util.*
import kotlin.math.PI
import kotlin.test.junit.JUnitAsserter.assertEquals

fun main(){
   val mas = arrayOf( -0.01, -0.1, -PI/6, -2.9, -PI, -3.5, -3 * PI/2, -6.1, -10 * PI)
    val ln = Ln(1e-5)
    val log2 = Log2(1e-5)
    val log3 = Log3(1e-5)
    val log5 = Log5(1e-5)
    val log10 = Log10(1e-5)
    val firstFun = FirstFun(1e-5)
//    for (value in mas){
//         println(" Mockito.`when`(" + "ln("+value +")).thenReturn(" + ln(value)+ ")")
//    }
//    for (value in mas){
//        println(" Mockito.`when`(" + "log2("+value +")).thenReturn(" + log2(value)+ ")")
//    }
//    for (value in mas){
//        println(" Mockito.`when`(" + "log5("+value +")).thenReturn(" + log5(value)+ ")")
//    }
//    for (value in mas){
//        println(" Mockito.`when`(" + "log10("+value +")).thenReturn(" + log10(value)+ ")")
//    }
    for (value in mas){
        try {
            println(" Mockito.`when`(" + "firstFun("+value +")).thenReturn(" + firstFun(value)+ ")")
        }catch (ex : Exception){}
//        println(" Mockito.`when`(" + "log3("+value +")).thenReturn(" + log3(value)+ ")")
    }
    for (value in mas){
        try {
            println("Assertions.assertEquals("+firstFun(value)+", systemFun("+value+"), accuracy)")
        }catch (ex : Exception){}
    }

}


class Main {
}
