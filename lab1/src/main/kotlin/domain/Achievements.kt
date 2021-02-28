package domain

interface Achievement {
    fun getAchievement() : String;
}
interface HumanAchievement : Achievement
interface DolphinAchievement : Achievement


class City (val name: String): HumanAchievement{
    override fun getAchievement() = name
}
class War (val name: String): HumanAchievement{
    override fun getAchievement() = name
}
class Wheel : HumanAchievement{
    override fun getAchievement() = "Wheel"
}

class HangOut : DolphinAchievement{
    override fun getAchievement() = "PLAY"
}

class Splashing : DolphinAchievement{
    override fun getAchievement(): String = "Splashing"
}
