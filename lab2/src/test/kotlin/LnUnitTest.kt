import main.kotlin.log.Ln
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class LnUnitTest {
    private val accuracy = 1e-5

    @Test
    fun `ln test`() {
        val ln = Ln(accuracy)
        assertEquals(-4.598027037504789, ln(0.01), accuracy)
        assertEquals(-2.3025283711696662, ln(0.1), accuracy)
        assertEquals(-0.2993633670813653, ln(0.74129), accuracy)
        assertEquals(0.33647223610798616, ln(1.4), accuracy)
        assertEquals(0.6931470737597851, ln(2.0), accuracy)
        assertEquals(0.9817036495249836, ln(2.669), accuracy)
        assertEquals(1.2527609036857006, ln(3.5), accuracy)
        assertEquals(2.351319541978252, ln(10.5), accuracy)
        assertEquals(4.602859604661796, ln(100.5), accuracy)
    }
}
