package moe.gensoukyo.easy_command

import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS

/**
 * Main mod class.
 *
 * An example for blocks is in the `blocks` package of this mod.
 */
@Mod(EasyCommand.ID)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
object EasyCommand {
    const val ID = "easy_command"

    // the logger for our mod
    val LOGGER: Logger = LogManager.getLogger(ID)

    init {

    }
}
