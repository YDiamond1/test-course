import domain.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
class DomainTest {


    @Test
    fun `Dolphin more clever than humans`(){
        val dolphin = Dolphin(arrayOf(HangOut(), Splashing()), Planet("Earth"))
        val human = Human("Pavel", arrayOf(City("NewYork"), War("WWW"), Wheel()), Planet("Earth"))

        assertTrue(dolphin > human)
    }
    @Test
    fun `Human more clever than dolphins`(){
        val dolphin = Dolphin(arrayOf(HangOut(), Splashing()), Planet("Earth"))
        val human = Human("Pavel", arrayOf(City("NewYork"), War("WWW"), Wheel()), Planet("Earth"))

        assertTrue(human > dolphin)
    }
}
