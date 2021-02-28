package domain

interface Location
{
    fun getLocation():String
}


class Planet(val name: String) : Location{
    override fun getLocation(): String = name
}
