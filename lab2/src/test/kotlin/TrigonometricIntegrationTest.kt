import main.kotlin.trig.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import kotlin.math.PI
import kotlin.test.assertFailsWith

class TrigonometricIntegrationTest {
    companion object {
        private const val accuracy = 1e-5
        private lateinit var csc: Csc
        private lateinit var tan: Tan
        private lateinit var cos: Cos
        private lateinit var cot: Cot
        @BeforeAll
        @JvmStatic
        fun setup() {
            val sin = Mockito.mock(Sin::class.java)
            Mockito.`when`(sin(0.0)).thenReturn(0.0)
            Mockito.`when`(sin(-0.1)).thenReturn(-0.09983341664682815)
            Mockito.`when`(sin(-PI / 6)).thenReturn(-0.5)
            Mockito.`when`(sin(-PI / 2)).thenReturn(-1.0)
            Mockito.`when`(sin(-2.9)).thenReturn(-0.23924932921398243)
            Mockito.`when`(sin(-PI)).thenReturn(0.0)
            Mockito.`when`(sin(-3.5)).thenReturn(0.35078322768961984)
            Mockito.`when`(sin(-3 * PI / 2)).thenReturn(1.0)
            Mockito.`when`(sin(-6.1)).thenReturn(0.182162504272095540024128363224657015)
            Mockito.`when`(sin(-10 * PI)).thenReturn(0.0)
            Mockito.`when`(sin(-3 * PI)).thenReturn(0.0)
            csc = Csc(accuracy, sin)
            tan = Tan(accuracy, sin)
            cos = Cos(accuracy, sin)
            cot = Cot(accuracy, )
        }
    }

    @Test
    fun `test csc`() {
        Assertions.assertEquals(-10.016686131634776, csc(-0.1), accuracy)
        Assertions.assertEquals(-2.0, csc(-PI / 6), accuracy)
        Assertions.assertEquals(-1.0, csc(-PI / 2), accuracy)
        Assertions.assertEquals(-4.1797400364103385, csc(-2.9), accuracy)
        Assertions.assertEquals(2.850763437540464, csc(-3.5), accuracy)
        Assertions.assertEquals(1.0, csc(-3 * PI / 2), accuracy)
        Assertions.assertEquals(5.489603, csc(-6.1), accuracy)

        assertFailsWith<IllegalArgumentException> {
            csc(0.0)
        }
        assertFailsWith<IllegalArgumentException> {
            csc(-PI)
        }
        assertFailsWith<IllegalArgumentException> {
            csc(-10 * PI)
        }
    }
    @Test
    fun `test tan`(){
        Assertions.assertEquals(-0.10033467208545055, tan(-0.1), accuracy)
        Assertions.assertEquals(-0.5773502691896257, tan(-PI/6), accuracy)
        Assertions.assertEquals(1.2246467991473532E-16, tan(-PI), accuracy)
        Assertions.assertEquals(0.24640539397196634, tan(-2.9), accuracy)
        Assertions.assertEquals(-0.3745856401585947, tan(-3.5), accuracy)
        Assertions.assertEquals(3.6739403974420594E-16, tan(-3 * PI), accuracy)
        Assertions.assertEquals(0.18526223068913525, tan(-6.1), accuracy)

        assertFailsWith<IllegalArgumentException> {
            tan(PI/2)
        }
        assertFailsWith<IllegalArgumentException> {
            tan(-PI/2)
        }
        assertFailsWith<IllegalArgumentException> {
            tan(5*PI/2)
        }
    }

    @Test
    fun `test cos`(){
        Assertions.assertEquals(0.9950041652780258, cos(-0.1), accuracy)
        Assertions.assertEquals(0.8660254037844387, cos(-PI/6), accuracy)
        Assertions.assertEquals(6.123233995736766E-17, cos(-PI/2), accuracy)
        Assertions.assertEquals(-0.9709581651495905, cos(-2.9), accuracy)
        Assertions.assertEquals(-0.9364566872907963, cos(-3.5), accuracy)
        Assertions.assertEquals(-1.8369701987210297E-16, cos(-3 * PI/2), accuracy)
        Assertions.assertEquals(0.9832684384425845, cos(-6.1), accuracy)
    }
    @Test
    fun `test cot`(){
        Assertions.assertEquals(-9.966644423259238, cot(-0.1), accuracy)
        Assertions.assertEquals(-1.7320508075688776, cot(-PI/6), accuracy)
        Assertions.assertEquals(-6.123233995736766E-17, cot(-PI/2), accuracy)
        Assertions.assertEquals(4.058352716555265, cot(-2.9), accuracy)
        Assertions.assertEquals(-2.669616484968866, cot(-3.5), accuracy)
        Assertions.assertEquals(-1.8369701987210297E-16, cot(-3 * PI/2), accuracy)
        Assertions.assertEquals(5.397754287423925, cot(-6.1), accuracy)

        assertFailsWith<IllegalArgumentException> {
            cot(0.0)
        }
        assertFailsWith<IllegalArgumentException> {
            cot(-PI)
        }
        assertFailsWith<IllegalArgumentException> {
            cot(-10 * PI)
        }
    }
}
