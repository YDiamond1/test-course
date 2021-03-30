import main.kotlin.system.SystemFun
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.PI
import kotlin.test.assertFailsWith

class FullIntegration {
    private val accuracy = 1e-5
    private val systemFun = SystemFun(accuracy)


    @Test
    fun `system test`(){

        Assertions.assertEquals(987920.534190227, systemFun(-0.1), accuracy)
        Assertions.assertEquals(18.03248242833788, systemFun(-PI / 6), accuracy)
        Assertions.assertEquals(4863.999874585743, systemFun(-2.9), accuracy)
        Assertions.assertEquals(363.18187749327967, systemFun(-3.5), accuracy)
        Assertions.assertEquals(25878.603458168578, systemFun(-6.1), accuracy)

        Assertions.assertEquals(143.4911384438482, systemFun(0.01), accuracy)
        Assertions.assertEquals(30.30156595569133, systemFun(0.1), accuracy)
        Assertions.assertEquals(1.3426849225243371, systemFun(0.74129), accuracy)
        Assertions.assertEquals(-0.5792052219286454, systemFun(1.4), accuracy)
        Assertions.assertEquals(-0.9233966602437964, systemFun(2.0), accuracy)
        Assertions.assertEquals(-0.9957449961238567, systemFun(2.669), accuracy)
        Assertions.assertEquals(-1.0006073204074453, systemFun(3.5), accuracy)
        Assertions.assertEquals(-2.2761754658264177, systemFun(10.5), accuracy)
        Assertions.assertEquals(-31.980329690373438, systemFun(100.5), accuracy)

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
            systemFun(-PI /2)
        }
        assertFailsWith<IllegalArgumentException> {
            systemFun(-3 * PI /2)
        }
    }
}
