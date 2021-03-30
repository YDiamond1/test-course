import main.kotlin.log.*
import main.kotlin.system.SecondFun
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.junit.jupiter.api.Assertions.assertEquals

class SecondIntegrationTest {
    companion object {
        private const val accuracy = 1e-5
        private lateinit var secondFun: SecondFun

        @BeforeAll
        @JvmStatic
        fun setup() {
            val ln = Mockito.mock(Ln::class.java)
            val log2 = Mockito.mock(Log2::class.java)
            val log5 = Mockito.mock(Log5::class.java)
            val log3 = Mockito.mock(Log3::class.java)
            val log10 = Mockito.mock(Log10::class.java)

            Mockito.`when`(ln(0.01)).thenReturn(-4.598027037504789)
            Mockito.`when`(ln(0.1)).thenReturn(-2.3025283711696662)
            Mockito.`when`(ln(0.74129)).thenReturn(-0.2993633670813653)
            Mockito.`when`(ln(1.4)).thenReturn(0.33647223610798616)
            Mockito.`when`(ln(2.0)).thenReturn(0.6931470737597851)
            Mockito.`when`(ln(2.669)).thenReturn(0.9817036495249836)
            Mockito.`when`(ln(3.5)).thenReturn(1.2527609036857006)
            Mockito.`when`(ln(10.5)).thenReturn(2.351319541978252)
            Mockito.`when`(ln(100.5)).thenReturn(4.602859604661796)

            Mockito.`when`(log2(0.01)).thenReturn(-6.633551826979604)
            Mockito.`when`(log2(0.1)).thenReturn(-3.321846774422975)
            Mockito.`when`(log2(0.74129)).thenReturn(-0.43189011165776303)
            Mockito.`when`(log2(1.4)).thenReturn(0.48542690122441884)
            Mockito.`when`(log2(2.0)).thenReturn(1.0)
            Mockito.`when`(log2(2.669)).thenReturn(1.4162992050157592)
            Mockito.`when`(log2(3.5)).thenReturn(1.807352221643878)
            Mockito.`when`(log2(10.5)).thenReturn(3.392237565433506)
            Mockito.`when`(log2(100.5)).thenReturn(6.6405237487260145)

            Mockito.`when`(log5(0.01)).thenReturn(-2.856924409058124)
            Mockito.`when`(log5(0.1)).thenReturn(-1.4306461124494012)
            Mockito.`when`(log5(0.74129)).thenReturn(-0.1860055418588193)
            Mockito.`when`(log5(1.4)).thenReturn(0.2090626558883676)
            Mockito.`when`(log5(2.0)).thenReturn(0.43067793597972714)
            Mockito.`when`(log5(2.669)).thenReturn(0.6099688183459157)
            Mockito.`when`(log5(3.5)).thenReturn(0.7783867244059597)
            Mockito.`when`(log5(10.5)).thenReturn(1.460961873033797)
            Mockito.`when`(log5(100.5)).thenReturn(2.8599270619256805)

            Mockito.`when`(log10(0.01)).thenReturn(-1.9969469627725045)
            Mockito.`when`(log10(0.1)).thenReturn(-0.9999999999999997)
            Mockito.`when`(log10(0.74129)).thenReturn(-0.13001506119522468)
            Mockito.`when`(log10(1.4)).thenReturn(0.14613163525844453)
            Mockito.`when`(log10(2.0)).thenReturn(0.3010373650282848)
            Mockito.`when`(log10(2.669)).thenReturn(0.4263589807695987)
            Mockito.`when`(log10(3.5)).thenReturn(0.5440805504816896)
            Mockito.`when`(log10(10.5)).thenReturn(1.0211902582480665)
            Mockito.`when`(log10(100.5)).thenReturn(1.9990457717242276)

            Mockito.`when`(log3(0.01)).thenReturn(-4.185308983257218)
            Mockito.`when`(log3(0.1)).thenReturn(-2.095853851544686)
            Mockito.`when`(log3(0.74129)).thenReturn(-0.2724925667648298)
            Mockito.`when`(log3(1.4)).thenReturn(0.30627055058893426)
            Mockito.`when`(log3(2.0)).thenReturn(0.6309303209533945)
            Mockito.`when`(log3(2.669)).thenReturn(0.8935861119866305)
            Mockito.`when`(log3(3.5)).thenReturn(1.1403133172776025)
            Mockito.`when`(log3(10.5)).thenReturn(2.1402655359091236)
            Mockito.`when`(log3(100.5)).thenReturn(4.189707780082343)

            secondFun = SecondFun(accuracy, ln, log2, log5, log3, log10)
        }
    }

    @Test
    fun test_right() {
        assertEquals(142.95618974957543, secondFun(0.01), accuracy)
        assertEquals(30.30042983147412, secondFun(0.1), accuracy)
        assertEquals(1.3427526353301884, secondFun(0.74129), accuracy)
        assertEquals(-0.5791844556004498, secondFun(1.4), accuracy)
        assertEquals(-0.9233903953939714, secondFun(2.0), accuracy)
        assertEquals(-0.9957440546471401, secondFun(2.669), accuracy)
        assertEquals(-1.0006070240398635, secondFun(3.5), accuracy)
        assertEquals(-2.2759593359746235, secondFun(10.5), accuracy)
        assertEquals(-31.78394255501753, secondFun(100.5), accuracy)
    }
}
