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
            Mockito.`when`(firstFun(-0.01)).thenReturn(9.998979920006941E11)
            Mockito.`when`(firstFun(-0.1)).thenReturn(987920.534190227)
            Mockito.`when`(firstFun(-PI / 6)).thenReturn(18.03248242833788)
            Mockito.`when`(firstFun(-PI / 2)).thenThrow(IllegalArgumentException(""))
            Mockito.`when`(firstFun(-2.9)).thenReturn(4863.999874585743)
            Mockito.`when`(firstFun(-PI)).thenThrow(IllegalArgumentException(""))
            Mockito.`when`(firstFun(-3.5)).thenReturn(363.18187749327967)
            Mockito.`when`(firstFun(-3 * PI / 2)).thenThrow(IllegalArgumentException(""))
            Mockito.`when`(firstFun(-6.1)).thenReturn(25878.603458168578)
            Mockito.`when`(firstFun(-10 * PI)).thenThrow(IllegalArgumentException(""))

            Mockito.`when`(secondFun(0.01)).thenReturn(143.4911384438482)
            Mockito.`when`(secondFun(0.1)).thenReturn(30.30156595569133)
            Mockito.`when`(secondFun(0.74129)).thenReturn(1.3426849225243371)
            Mockito.`when`(secondFun(1.4)).thenReturn(-0.5792052219286454)
            Mockito.`when`(secondFun(2.0)).thenReturn(-0.9233966602437964)
            Mockito.`when`(secondFun(2.669)).thenReturn(-0.9957449961238567)
            Mockito.`when`(secondFun(3.5)).thenReturn(-1.0006073204074453)
            Mockito.`when`(secondFun(10.5)).thenReturn(-2.2761754658264177)
            Mockito.`when`(secondFun(100.5)).thenReturn(-31.980329690373438)

            systemFun = SystemFun(accuracy, firstFun, secondFun)
        }
    }

    @Test
    fun `test trigonometric`(){
        Assertions.assertEquals(9.998979920006941E11, systemFun(-0.01), accuracy)
        Assertions.assertEquals(987920.534190227, systemFun(-0.1), accuracy)
        Assertions.assertEquals(18.03248242833788, systemFun(-PI / 6), accuracy)
        Assertions.assertEquals(4863.999874585743, systemFun(-2.9), accuracy)
        Assertions.assertEquals(363.18187749327967, systemFun(-3.5), accuracy)
        Assertions.assertEquals(25878.603458168578, systemFun(-6.1), accuracy)

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
        Assertions.assertEquals(143.4911384438482, systemFun(0.01), accuracy)
        Assertions.assertEquals(30.30156595569133, systemFun(0.1), accuracy)
        Assertions.assertEquals(1.3426849225243371, systemFun(0.74129), accuracy)
        Assertions.assertEquals(-0.5792052219286454, systemFun(1.4), accuracy)
        Assertions.assertEquals(-0.9233966602437964, systemFun(2.0), accuracy)
        Assertions.assertEquals(-0.9957449961238567, systemFun(2.669), accuracy)
        Assertions.assertEquals(-1.0006073204074453, systemFun(3.5), accuracy)
        Assertions.assertEquals(-2.2761754658264177, systemFun(10.5), accuracy)
        Assertions.assertEquals(-31.980329690373438, systemFun(100.5), accuracy)
    }

}
