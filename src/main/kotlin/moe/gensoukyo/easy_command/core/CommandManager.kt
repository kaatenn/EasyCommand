package moe.gensoukyo.easy_command.core

import com.google.gson.JsonObject

object CommandManager {
    val commands = mutableListOf<String>()

    fun fromJson(json: JsonObject){
        val commandsArray = json.getAsJsonArray("commands")
            ?: throw IllegalArgumentException("The json misses \"commands\" field")
        commands.clear()
        for (element in commandsArray) {
            commands.add(element.asString)
        }
    }
}