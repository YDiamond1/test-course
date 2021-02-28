package domain

interface Entity{
    fun getEntity(): String
}

class Dolphin (val achievements: Array<DolphinAchievement>, val location: Location) : Entity {
    override fun getEntity(): String = "DOLPHIN"

    operator fun compareTo(entity: Entity): Int {
        var isHangOut = false
        var isSplashing = false

        achievements.forEach {
            when (it) {
                is HangOut -> isHangOut = true
                is Splashing -> isSplashing = true
            }
        }
        return if (entity is Human) {
            if (isHangOut && isSplashing && location.getLocation() == "Earth") 1
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
                is City -> isCity = true
                is War -> isWar = true
                is Wheel -> isWheel = true
            }
        }
        return if(entity is Dolphin){
            if (isCity && isWar && isWheel && location.getLocation() == "Earth") 1
            else 0
        }
        else 0

    }
}

