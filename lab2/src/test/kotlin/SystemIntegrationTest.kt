import main.kotlin.system.FirstFun
import main.kotlin.system.SecondFun
import main.kotlin.system.SystemFun
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import kotlin.math.PI
import kotlin.test.assertFailsWith

class SystemIntegrationTest {
    companion object {
        private const val accuracy = 1e-5
        private lateinit var systemFun: SystemFun
        @BeforeAll
        @JvmStatic
        fun setup() {
            val firstFun = Mockito.mock(FirstFun::class.java)
            val secondFun = Mockito.mock(SecondFun::class.java)
            Mockito.`when`(firstFun(0.0)).thenThrow(IllegalArgumentException(""))
            Mockito.`when`(firstFun(-0.01)).thenReturn(9.998979920006947E11)
            Mockito.`when`(firstFun(-0.1)).thenReturn(987920.534190226)
            Mockito.`when`(firstFun(-PI / 6)).thenReturn(18.032482428352985)
            Mockito.`when`(firstFun(-PI / 2)).thenThrow(IllegalArgumentException(""))
            Mockito.`when`(firstFun(-2.9)).thenReturn(4864.000038360934)
            Mockito.`when`(firstFun(-PI)).thenThrow(IllegalArgumentException(""))
            Mockito.`when`(firstFun(-3.5)).thenReturn(363.1818815069505)
            Mockito.`when`(firstFun(-3 * PI / 2)).thenThrow(IllegalArgumentException(""))
            Mockito.`when`(firstFun(-6.1)).thenReturn(25878.60341525115)
            Mockito.`when`(firstFun(-10 * PI)).thenThrow(IllegalArgumentException(""))

            Mockito.`when`(secondFun(0.01)).thenReturn(142.95618974957543)
            Mockito.`when`(secondFun(0.1)).thenReturn(30.30042983147412)
            Mockito.`when`(secondFun(0.74129)).thenReturn(1.3427526353301884)
            Mockito.`when`(secondFun(1.4)).thenReturn(-0.5791844556004498)
            Mockito.`when`(secondFun(2.0)).thenReturn(-0.9233903953939714)
            Mockito.`when`(secondFun(2.669)).thenReturn(-0.9957440546471401)
            Mockito.`when`(secondFun(3.5)).thenReturn(-1.0006070240398635)
            Mockito.`when`(secondFun(10.5)).thenReturn(-2.2759593359746235)
            Mockito.`when`(secondFun(100.5)).thenReturn(-31.78394255501753)

            systemFun = SystemFun(accuracy, firstFun, secondFun)
        }
    }

    @Test
    fun `test trigonometric`(){
        Assertions.assertEquals(9.998979920006947E11, systemFun(-0.01), accuracy)
        Assertions.assertEquals(987920.534190226, systemFun(-0.1), accuracy)
        Assertions.assertEquals(18.032482428352985, systemFun(-PI/6), accuracy)
        Assertions.assertEquals(4864.000038360934, systemFun(-2.9), accuracy)
        Assertions.assertEquals(363.1818815069505, systemFun(-3.5), accuracy)
        Assertions.assertEquals(25878.60341525115, systemFun(-6.1), accuracy)

        assertFailsWith<IllegalArgumentException> {
            systemFun(0.0)
        }
        assertFailsWith<IllegalArgumentException> {
            systemFun(-PI)
        }
        assertFailsWith<IllegalArgumentException> {
            systemFun(-10* PI)
        }
        assertFailsWith<IllegalArgumentException> {
            systemFun(-PI/2)
        }
        assertFailsWith<IllegalArgumentException> {
            systemFun(-3 * PI /2)
        }
    }

    @Test
    fun test_right() {
        Assertions.assertEquals(142.95618974957543, systemFun(0.01), accuracy)
        Assertions.assertEquals(30.30042983147412, systemFun(0.1), accuracy)
        Assertions.assertEquals(1.3427526353301884, systemFun(0.74129), accuracy)
        Assertions.assertEquals(-0.5791844556004498, systemFun(1.4), accuracy)
        Assertions.assertEquals(-0.9233903953939714, systemFun(2.0), accuracy)
        Assertions.assertEquals(-0.9957440546471401, systemFun(2.669), accuracy)
        Assertions.assertEquals(-1.0006070240398635, systemFun(3.5), accuracy)
        Assertions.assertEquals(-2.2759593359746235, systemFun(10.5), accuracy)
        Assertions.assertEquals(-31.78394255501753, systemFun(100.5), accuracy)
    }

}
