package main.kotlin


import main.kotlin.log.Ln
import main.kotlin.log.Log3
import main.kotlin.trig.Sin
import java.util.*
import kotlin.math.*
import kotlin.test.junit.JUnitAsserter.assertEquals

fun main(){
    val mas = arrayOf( 0.01, 0.1, 0.74129, 1.4, 2.0, 2.669, 3.5, 10.5, 100.5)
    val log3 = Log3(1e-5)
    for (value in mas){
         println(" Mockito.`when`(" + "log3("+value +")).thenReturn(" + log3(value)+ ")")
    }

}


class Main {
}
