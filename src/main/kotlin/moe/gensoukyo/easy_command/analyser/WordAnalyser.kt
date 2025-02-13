package moe.gensoukyo.easy_command.analyser

import moe.gensoukyo.easy_command.core.CommandManager
import moe.gensoukyo.easy_command.core.GrammarTreeManager

object WordAnalyser {
    fun wordAnalyse() {
        GrammarTreeManager.grammarForest.clear()
        for (command in CommandManager.commands) {
        }
    }


}