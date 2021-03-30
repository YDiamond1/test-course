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

        Assertions.assertEquals(9.998979920006947E11, systemFun(-0.01), accuracy)
        Assertions.assertEquals(987920.534190226, systemFun(-0.1), accuracy)
        Assertions.assertEquals(18.032482428352985, systemFun(-0.5235987755982988), accuracy)
        Assertions.assertEquals(4864.000038360934, systemFun(-2.9), accuracy)
        Assertions.assertEquals(363.1818815069505, systemFun(-3.5), accuracy)
        Assertions.assertEquals(25878.60341525115, systemFun(-6.1), accuracy)

        Assertions.assertEquals(142.95618974957543, systemFun(0.01), accuracy)
        Assertions.assertEquals(30.30042983147412, systemFun(0.1), accuracy)
        Assertions.assertEquals(1.3427526353301884, systemFun(0.74129), accuracy)
        Assertions.assertEquals(-0.5791844556004498, systemFun(1.4), accuracy)
        Assertions.assertEquals(-0.9233903953939714, systemFun(2.0), accuracy)
        Assertions.assertEquals(-0.9957440546471401, systemFun(2.669), accuracy)
        Assertions.assertEquals(-1.0006070240398635, systemFun(3.5), accuracy)
        Assertions.assertEquals(-2.2759593359746235, systemFun(10.5), accuracy)
        Assertions.assertEquals(-31.78394255501753, systemFun(100.5), accuracy)

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
