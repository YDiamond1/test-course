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
    fun `Dolphin dont have enough achievements`(){
        val dolphin = Dolphin(arrayOf(HangOut()), Planet("Earth"))
        val human = Human("Pavel", arrayOf(City("NewYork"), War("WWW"), Wheel()), Planet("Earth"))

        assertFalse(dolphin > human)
    }

    @Test
    fun `Dolphin dont have enough achievements 2`(){
        val dolphin = Dolphin(arrayOf(Splashing()), Planet("Earth"))
        val human = Human("Pavel", arrayOf(City("NewYork"), War("WWW"), Wheel()), Planet("Earth"))

        assertFalse(dolphin > human)
    }

    @Test
    fun `Dolphin is not on earth`(){
        val dolphin = Dolphin(arrayOf(HangOut(), Splashing()), Planet("Venera"))
        val human = Human("Pavel", arrayOf(City("NewYork"), War("WWW"), Wheel()), Planet("Earth"))

        assertFalse(dolphin > human)
    }

    @Test
    fun `Human more clever than dolphins`(){
        val dolphin = Dolphin(arrayOf(HangOut(), Splashing()), Planet("Earth"))
        val human = Human("Pavel", arrayOf(City("NewYork"), War("WWW"), Wheel()), Planet("Earth"))

        assertTrue(human > dolphin)
    }

    @Test
    fun `Human dont have enough achievements`(){
        val dolphin = Dolphin(arrayOf(HangOut(), Splashing()), Planet("Earth"))
        val human = Human("Pavel", arrayOf(City("NewYork"),  Wheel()), Planet("Earth"))

        assertFalse(human > dolphin)
    }

    @Test
    fun `Human dont have enough achievements 2`(){
        val dolphin = Dolphin(arrayOf(HangOut(), Splashing()), Planet("Earth"))
        val human = Human("Pavel", arrayOf( War("WWW"), Wheel()), Planet("Earth"))

        assertFalse(human > dolphin)
    }

    @Test
    fun `Human dont have enough achievements 3`(){
        val dolphin = Dolphin(arrayOf(HangOut(), Splashing()), Planet("Earth"))
        val human = Human("Pavel", arrayOf(City("NewYork"), War("WWW")), Planet("Earth"))

        assertFalse(human > dolphin)
    }

    @Test
    fun `Human is not on earth` (){
        val dolphin = Dolphin(arrayOf(HangOut(), Splashing()), Planet("Earth"))
        val human = Human("Pavel", arrayOf(City("NewYork"), War("WWW")), Planet("Mars"))

        assertFalse(human > dolphin)
    }

}
