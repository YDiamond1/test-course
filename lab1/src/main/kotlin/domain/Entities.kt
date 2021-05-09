package domain

interface Entity{
    fun getEntity(): String
}

class Dolphin (val achievements: Array<DolphinAchievement>, val location: Location) : Entity {
    override fun getEntity(): String = "Dolphin"

    operator fun compareTo(entity: Entity): Int {
        var isHangOut = false
        var isSplashing = false

        achievements.forEach {
            when (it) {
                is HangOut -> {
                    if(it.getAchievement() == "Play")
                    isHangOut = true

                }

                is Splashing -> {
                    if(it.getAchievement() == "Splashing")
                        isSplashing = true
                }
            }
        }
        return if (entity is Human) {
            if (isHangOut && isSplashing && location.getLocation() == "Earth" && getEntity() == "Dolphin") 1
            else 0
        } else 0


    }

}
class Human(val name: String,val achievements: Array<HumanAchievement>, val location: Location) : Entity {

    override fun getEntity() = name


    operator fun compareTo(entity: Entity) : Int{
        var isCity = false
        var isWar = false
        var isWheel = false
        achievements.forEach {
            when (it) {
                is City ->{
                    if(it.getAchievement() == "NewYork")
                    isCity = true
                }
                is War -> {
                    if(it.getAchievement() == "WWW")
                    isWar = true
                }
                is Wheel ->{
                    if(it.getAchievement() == "Wheel")
                    isWheel = true
                }
            }
        }
        return if(entity is Dolphin){
            if (isCity && isWar && isWheel && location.getLocation() == "Earth" && getEntity() == name) 1
            else 0
        }
        else 0

    }
}

