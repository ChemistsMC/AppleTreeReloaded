package me.ebonjaeger.appletreereloaded

import me.ebonjaeger.appletreereloaded.configuration.Settings
import me.ebonjaeger.appletreereloaded.listener.BlockBreakListener
import me.ebonjaeger.appletreereloaded.listener.LeafDecayListener
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.nio.file.Files

class AppleTreeReloaded : JavaPlugin() {

    override fun onEnable() {
        // Create config file if it does not exist
        if (!Files.exists(File(dataFolder, "config.yml").toPath())) {
            saveResource("config.yml", false)
        }

        val settings = Settings.create(File(dataFolder, "config.yml"))

        server.pluginManager.registerEvents(BlockBreakListener(settings), this)
        server.pluginManager.registerEvents(LeafDecayListener(settings), this)
    }
}
