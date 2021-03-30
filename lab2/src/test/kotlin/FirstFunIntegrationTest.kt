import main.kotlin.system.FirstFun
import main.kotlin.trig.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import kotlin.math.PI
import kotlin.test.assertFailsWith
import org.junit.jupiter.api.Assertions.assertEquals

class FirstFunIntegrationTest {
    companion object {
        private const val accuracy = 1e-5
        private lateinit var firstFun: FirstFun
        @BeforeAll
        @JvmStatic
        fun setup() {
            val csc = Mockito.mock(Csc::class.java)
            val tan = Mockito.mock(Tan::class.java)
            val sin = Mockito.mock(Sin::class.java)
            val cot = Mockito.mock(Cot::class.java)

            Mockito.`when`(csc(0.0)).thenThrow(IllegalArgumentException(""))
            Mockito.`when`(csc(-0.01)).thenReturn(-100.001666686111316)
            Mockito.`when`(csc(-0.1)).thenReturn(-10.016686131634776)
            Mockito.`when`(csc(-PI / 6)).thenReturn(-2.0)
            Mockito.`when`(csc(-PI / 2)).thenReturn(-1.0)
            Mockito.`when`(csc(-2.9)).thenReturn(-4.1797400364103385)
            Mockito.`when`(csc(-PI)).thenThrow(IllegalArgumentException(""))
            Mockito.`when`(csc(-3.5)).thenReturn(2.850763437540464)
            Mockito.`when`(csc(-3 * PI / 2)).thenReturn(1.0)
            Mockito.`when`(csc(-6.1)).thenReturn(5.48960)
            Mockito.`when`(csc(-10 * PI)).thenThrow(IllegalArgumentException(""))

            Mockito.`when`(tan(0.0)).thenReturn(0.0)
            Mockito.`when`(tan(-0.01)).thenReturn(-0.010000333346667207)
            Mockito.`when`(tan(-0.1)).thenReturn(-0.10033467208545055)
            Mockito.`when`(tan(-PI/6)).thenReturn(-0.5773502691896257)
            Mockito.`when`(tan(-PI/2)).thenThrow(IllegalArgumentException(""))
            Mockito.`when`(tan(-2.9)).thenReturn(0.24640539397196634)
            Mockito.`when`(tan(-PI)).thenReturn(0.0)
            Mockito.`when`(tan(-3.5)).thenReturn(-0.3745856401585947)
            Mockito.`when`(tan(-3*PI/2)).thenThrow(IllegalArgumentException(""))
            Mockito.`when`(tan(-6.1)).thenReturn(0.18526223068913525)
            Mockito.`when`(tan(-10*PI)).thenReturn(0.0)

            Mockito.`when`(sin(0.0)).thenReturn(0.0)
            Mockito.`when`(sin(-0.01)).thenReturn(-0.009999833334166664)
            Mockito.`when`(sin(-0.1)).thenReturn(-0.09983341664682815)
            Mockito.`when`(sin(-PI / 6)).thenReturn(-0.5)
            Mockito.`when`(sin(-PI / 2)).thenReturn(-1.0)
            Mockito.`when`(sin(-2.9)).thenReturn(-0.23924932921398243)
            Mockito.`when`(sin(-PI)).thenReturn(0.0)
            Mockito.`when`(sin(-3.5)).thenReturn(0.35078322768961984)
            Mockito.`when`(sin(-3 * PI / 2)).thenReturn(1.0)
            Mockito.`when`(sin(-6.1)).thenReturn(0.182162504272095540024128363224657015)
            Mockito.`when`(sin(-10 * PI)).thenReturn(0.0)

            Mockito.`when`(cot(0.0)).thenThrow(IllegalArgumentException(""))
            Mockito.`when`(cot(-0.01)).thenReturn(-99.99666664444422)
            Mockito.`when`(cot(-0.1)).thenReturn(-9.966644423259238)
            Mockito.`when`(cot(-PI/6)).thenReturn(-1.7320508075688774)
            Mockito.`when`(cot(-PI/2)).thenReturn(0.0)
            Mockito.`when`(cot(-2.9)).thenReturn(4.058352716555265)
            Mockito.`when`(cot(-PI)).thenThrow(IllegalArgumentException(""))
            Mockito.`when`(cot(-3.5)).thenReturn(-2.669616484968866)
            Mockito.`when`(cot(-3*PI/2)).thenReturn(0.0)
            Mockito.`when`(cot(-6.1)).thenReturn(5.397754287423925)
            Mockito.`when`(cot(-10*PI)).thenThrow(IllegalArgumentException(""))

            firstFun = FirstFun(accuracy, tan = tan, csc = csc, sin = sin, cot = cot)
        }
    }


    @Test
    fun `test trigonometric`(){
        assertEquals(9.998979920006941E11, firstFun(-0.01), accuracy)
        assertEquals(987920.534190227, firstFun(-0.1), accuracy)
        assertEquals(18.03248242833788, firstFun(-PI /6), accuracy)
        assertEquals(4863.999874585743, firstFun(-2.9), accuracy)
        assertEquals(363.18187749327967, firstFun(-3.5), accuracy)
        assertEquals(25878.603458168578, firstFun(-6.1), accuracy)

        assertFailsWith<IllegalArgumentException> {
            firstFun(0.0)
        }
        assertFailsWith<IllegalArgumentException> {
            firstFun(-PI)
        }
        assertFailsWith<IllegalArgumentException> {
            firstFun(-10* PI)
        }
        assertFailsWith<IllegalArgumentException> {
            firstFun(-PI/2)
        }
        assertFailsWith<IllegalArgumentException> {
            firstFun(-3 * PI /2)
        }
    }
}
