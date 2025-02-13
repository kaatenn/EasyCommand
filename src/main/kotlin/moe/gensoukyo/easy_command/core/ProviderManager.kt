package moe.gensoukyo.easy_command.core

import com.mojang.brigadier.arguments.ArgumentType
import com.mojang.brigadier.builder.ArgumentBuilder
import net.minecraft.commands.CommandSourceStack
import net.minecraft.commands.Commands
import net.minecraft.commands.arguments.coordinates.BlockPosArgument

private typealias CommandBuilderProvider = (Array<out Any>) -> ArgumentBuilder<CommandSourceStack, *>
private typealias ArgumentTypeProvider = (Array<out Any>) -> ArgumentType<*>

object ProviderManager {
    private val ARGUMENT_TYPE_PROVIDERS = HashMap<String, ArgumentTypeProvider>()
    private val COMMAND_PROVIDERS = HashMap<String, CommandBuilderProvider>()

    const val LITERAL_TYPE = "l"
    const val BLOCKPOS_TYPE = "bp"

    init {
        COMMAND_PROVIDERS[LITERAL_TYPE] = { args ->
            Commands.literal(args[0] as String)
        }
        ARGUMENT_TYPE_PROVIDERS[BLOCKPOS_TYPE] = { BlockPosArgument.blockPos() }
    }
}