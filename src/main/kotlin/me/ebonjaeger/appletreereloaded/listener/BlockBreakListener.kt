package me.ebonjaeger.appletreereloaded.listener

import me.ebonjaeger.appletreereloaded.Utils
import me.ebonjaeger.appletreereloaded.configuration.PluginSettings
import me.ebonjaeger.appletreereloaded.configuration.Settings
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.inventory.ItemStack

class BlockBreakListener(private val settings: Settings) : Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    fun onBlockBreak(event: BlockBreakEvent) {
        if (event.isCancelled) {
            return
        }

        val block = event.block
        val world = block.world

        if (settings.getProperty(PluginSettings.IGNORED_WORLDS).contains(world.name)) {
            return
        }

        if (!Utils.isLeafBlock(block.type)) {
            return
        }

        val rand = Math.random() // Generates a number greater than or equal to 0.0 less than 1.0

        // See if we should drop extra apples
        if (block.type == Material.OAK_LEAVES || !settings.getProperty(PluginSettings.MATCH_DROPS)) {
            if (rand <= settings.getProperty(PluginSettings.APPLE_CHANCE)) {
                world.dropItemNaturally(block.location, ItemStack(Material.APPLE, 1))
            } else if (settings.getProperty(PluginSettings.GOLDEN_APPLE_CHANCE) > 0.0 &&
                    rand <= settings.getProperty(PluginSettings.GOLDEN_APPLE_CHANCE)) {
                world.dropItemNaturally(block.location, ItemStack(Material.GOLDEN_APPLE, 1))
            }
        }

        // See if we should drop extra cocoa
        if (block.type == Material.JUNGLE_LEAVES || !settings.getProperty(PluginSettings.MATCH_DROPS)) {
            if (settings.getProperty(PluginSettings.COCOA_CHANCE) > 0.0 &&
                    rand <= settings.getProperty(PluginSettings.COCOA_CHANCE)) {
                world.dropItemNaturally(block.location, ItemStack(Material.COCOA_BEANS, 1))
            }
        }

        // Check for leaf drop
        if (settings.getProperty(PluginSettings.DROP_LEAVES)) {
            world.dropItemNaturally(block.location, ItemStack(block.type, 1))
        }

        // Check for sapling drop
        if (settings.getProperty(PluginSettings.SAPLING_CHANCE) > 0.0 &&
                rand <= settings.getProperty(PluginSettings.SAPLING_CHANCE)) {
            val sapling = ItemStack(Utils.getSaplingType(block.type), 1)
            world.dropItemNaturally(block.location, sapling)
        }
    }
}
