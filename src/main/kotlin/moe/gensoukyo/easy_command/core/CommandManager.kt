package moe.gensoukyo.easy_command.core

import com.google.gson.JsonObject

object CommandManager {
    private val commands = mutableMapOf<String, String>()

    fun fromJson(json: JsonObject){
        for ((key, value) in json.entrySet()) {
            commands[key] = value.asString
        }
    }
}