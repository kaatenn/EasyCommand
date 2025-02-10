package moe.gensoukyo.easy_command.core

import com.mojang.brigadier.context.CommandContext
import net.minecraft.commands.CommandSourceStack

object ExecutorManager {
    private val EXECUTORS = mutableMapOf<String, CommandContext<CommandSourceStack>>()
}